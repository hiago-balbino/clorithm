(defproject clorithm "1.0.0"
  :description "Project used to store some exercises"
  :license {:name "MIT License"
            :url "https://opensource.org/license/mit"}
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :main ^:skip-aot clorithm.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
