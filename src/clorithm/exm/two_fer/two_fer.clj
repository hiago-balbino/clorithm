(ns clorithm.exm.two-fer.two-fer)

(defn two-fer
  [& [name]]
  (format "One for %s, one for me." (or name "you")))