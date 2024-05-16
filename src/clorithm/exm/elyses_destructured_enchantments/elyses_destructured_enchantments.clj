(ns clorithm.exm.elyses-destructured-enchantments.elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (let [[first-card-from-deck] deck]
    first-card-from-deck))

(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[_ second-card-from-deck] deck]
    second-card-from-deck))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [[first-card-from-deck second-card-from-deck & remaining] deck]
    (vec (concat [second-card-from-deck first-card-from-deck] (vec remaining)))))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  (let [[first-card-from-deck & remaining] deck]
    [first-card-from-deck remaining]))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (let [[first-card-from-deck & remaining] deck]
    (remove nil? (flatten [first-card-from-deck face-cards remaining]))))