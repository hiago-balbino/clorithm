(ns clorithm.exm.collatz-conjecture.collatz-conjecture)

(defn collatz
  [num]
  (loop [value num
         iteractions 0]
    (cond
      (<= value 0) (throw IllegalArgumentException)
      (= 1 value) iteractions
      (even? value)   (recur (/ value 2) (inc iteractions))
      :else   (recur (+ 1 (* value 3)) (inc iteractions)))))