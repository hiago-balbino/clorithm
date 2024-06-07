(ns clorithm.exm.all-your-base.all-your-base)

(defn- has-invalid-base?
  "Checks if some base(from or to) is less than two."
  [from-base to-base]
  (some #(< % 2) (list from-base to-base)))

(defn- has-valid-digits?
  "Perform two checks:
   
   * It has some negative digit
   * It has some digit less than base"
  [from-base digits]
  (not-every? #(and (not (neg? %)) (< % from-base)) digits))

(defn- zeroes?
  "Checks if every value in `digits` collection is zero."
  [digits]
  (every? #(zero? %) digits))

(defn- to-decimal
  "Converts the collection of digits to decimal from base.
   
   Uses reduce to process each digit and apply the formula for positional notation.

   Accumulates the result by multiplying the current total by the base and adding the next digit."
  [from-base digits]
  (reduce #(+ (* from-base %1) %2) 0 digits))

(defn- from-decimal
  "Uses a loop to repeatedly divide the decimal number by the target base.
   
   Collects remainders in a list, which are the digits of the target base number.
   
   Returns the digits in the correct order."
  [to-base decimal]
  (loop [number decimal
         result '()]
    (if (zero? number)
      (if (empty? result)
        '(0)
        result)
      (recur (quot number to-base) (cons (mod number to-base) result)))))

(defn convert [from-base digits to-base]
  (cond
    (has-invalid-base? from-base to-base) nil
    (has-valid-digits? from-base digits) nil
    (empty? digits) ()
    (zeroes? digits) '(0)
    :else (->> digits
               (to-decimal from-base)
               (from-decimal to-base))))
