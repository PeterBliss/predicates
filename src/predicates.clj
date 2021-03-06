(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [whites (filter whitespace? string)
        len (count string)]
    (or (= 0 len)
        (= len (count whites)))))

;(def books #{cities, wild-seed, lord-of-light,
;             deus-irae, ysabel, scanner-darkly})

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [pred-func
        (fn [award] (has-award? book award))]
    (every? pred-func awards)))

(defn my-some [pred a-seq]
  (let [some-val (some pred a-seq)]
    (if (= some-val nil)
      false
      some-val)))

(defn my-every? [pred a-seq]
  (every? pred a-seq))

(defn prime? [n]
  (let [pred 
        (fn [denom] (= 0 (mod n denom)))]
    (not (some pred (range 2 n)))))

;^^
