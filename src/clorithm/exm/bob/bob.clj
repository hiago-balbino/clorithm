(ns clorithm.exm.bob.bob
  (:require [clojure.string :as s]))

(defn capitalized?
  [input]
  (and
    (re-find #"[a-zA-Z]" input)
    (= (s/upper-case input) input)))

(defn question?
  [input]
  (s/ends-with? input "?"))

(defn response-for
  [input]
  (let [input (s/replace input #"[ \t\n\r]" "")]
    (cond
    (and (capitalized? input) (question? input)) "Calm down, I know what I'm doing!"
    (question? input) "Sure."
    (capitalized? input) "Whoa, chill out!"
    (empty? input) "Fine. Be that way!"
    :else "Whatever.")))
