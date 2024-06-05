(ns clorithm.exm.acronym.acronym
  (:require [clojure.string :as str]))

(defn acronym
  "## Convert a phrase to its acronym.
   
   ### Regex explained
   
   `[A-Z]+[a-z]*`
   * `[A-Z]+`: This part matches one or more uppercase letters. The + quantifier means **one or more** of the preceding element (uppercase letters in this case).
   * `[a-z]*`: This part matches zero or more lowercase letters. The * quantifier means **zero or more** of the preceding element (lowercase letters in this case).
   * Combined [A-Z]+[a-z]* matches sequences that start with one or more uppercase letters, optionally followed by zero or more lowercase letters. Examples: **Hyper**, **Text**, **Preprocessor**.
                                                                                                                                                                                                  
   `|`
   * This is the alternation operator, meaning **or**. It allows for matching either the pattern on the left side or the pattern on the right side of the operator.

   `[a-z]+`
   * This part matches one or more lowercase letters. The + quantifier means **one or more** of the preceding element (lowercase letters in this case).
   * This part ensures that sequences of lowercase letters are also matched, which could include whole words in lowercase. Examples: **markup**.

   When combined, the regex `[A-Z]+[a-z]*|[a-z]+` will match:
    * Any word that starts with one or more uppercase letters followed by zero or more lowercase letters.
    * Any sequence of one or more lowercase letters.
   
   ### Examples
   Let's see how this regex works with different input strings:

   ```
   Input: HyperText
   Matches: Hyper, Text
      
   Input: markup
   Matches: markup

   Input: Preprocessor
   Matches: Preprocessor

   Input: PHP: Hypertext Preprocessor
   Matches: PHP, Hypertext, Preprocessor
   ```
   "
  [phrase]
  (->> (re-seq #"[A-Z]+[a-z]*|[a-z]+" phrase)
       (map (comp first))
       (apply str)
       (str/upper-case)))