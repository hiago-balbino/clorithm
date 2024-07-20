(ns clorithm.exm.anagram.anagram
  (:require [clojure.string :as s]))

(defn normalize
  [word]
  (sort (s/lower-case word)))

(defn is-same-order?
  [word prospect]
  (= (s/lower-case word) (s/lower-case prospect)))

(defn is-anagram?
  [word prospect]
  (if (is-same-order? word prospect)
    false
    (= (normalize word) (normalize prospect))))

(defn anagrams-for
  [word prospect-list]
  (filterv #(is-anagram? word %) prospect-list))