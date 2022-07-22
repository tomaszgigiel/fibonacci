(defproject fibonacci-lein "1000-SNAPSHOT"
  :description "fibonacci: fibonacci"
  :url "http://tomaszgigiel.pl"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.11.0"]
                 [org.clojure/tools.cli "1.0.206"]
                 [org.clojure/tools.logging "1.2.4"]
                 ]

  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :resource-paths ["src/main/resources" "src/test/resources"]
  :target-path "target/%s"
  :jar-name "fibonacci-lein.jar"
  :uberjar-name "fibonacci-lein-uberjar.jar"
  :main pl.tomaszgigiel.fibonacci.core
  :aot [pl.tomaszgigiel.fibonacci.core]

  :profiles {:test {:resource-paths ["src/test/resources"]}
             :main-core {:main pl.tomaszgigiel.fibonacci.core}}

  :aliases {"run-main-core" ["with-profile" "main-core" "run"]}
)
