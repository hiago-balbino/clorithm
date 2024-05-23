(ns clorithm.exm.armstrong-numbers.armstrong-numbers)

(defn armstrong?
  [num]
  (let [num-as-str (str num)
        num-digits (count num-as-str)
        sum-of-digits (->> num-as-str
                           (map #(Character/digit % 10))
                           (map #(Math/pow % num-digits))
                           (reduce +)
                           (long))]
    (= num sum-of-digits)))