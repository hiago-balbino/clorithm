(ns clorithm.exm.card-games.card-games)

(def ^:private jack-card 11)

(defn rounds
  "Takes the current round number and returns 
   a `list` with that round and the _next two_."
  [n]
  (list n (+ n 1) (+ n 2)))

(defn concat-rounds
  "Takes two lists and returns a single `list` 
   consisting of all the rounds in the first `list`, 
   followed by all the rounds in the second `list`"
  [l1 l2]
  (concat l1 l2))

(defn contains-round?
  "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
  [l n]
  (contains? (set l) n))

(defn card-average
  "Returns the average value of a hand"
  [hand]
  (double (/ (reduce + hand) (count hand))))

(defn- card-edges-average [hand]
  (double (/ (+ (first hand) (last hand)) 2)))

(defn- card-median-avg [hand]
  (double (nth hand (quot (count hand) 2))))

(defn approx-average?
  "Returns `true` if average is equal to either one of:
  - Take the average of the _first_ and _last_ number in the hand.
  - Using the median (middle card) of the hand."
  [hand]
  (let [actual_avg (card-average hand)
        edges_avg (card-edges-average hand)
        median_avg (card-median-avg hand)]
    (or (= actual_avg edges_avg)
        (= actual_avg median_avg))))

(defn- numbers-by-type-of-index
  [predicate hand]
  (->> hand
       (map-indexed vector)
       (filter #(predicate (first %)))
       (map second)))

(defn average-even-odd?
  "Returns true if the average of the cards at even indexes 
   is the same as the average of the cards at odd indexes."
  [hand]
  (let [even-avg (card-average (numbers-by-type-of-index even? hand))
        odd-avg (card-average (numbers-by-type-of-index odd? hand))]
    (= even-avg odd-avg)))

(defn maybe-double-last
  "If the last card is a Jack (11), doubles its value
   before returning the hand."
  [hand]
  (if
   (= (last hand) jack-card)
    (concat (butlast hand) (list (* (last hand) 2)))
    hand))
