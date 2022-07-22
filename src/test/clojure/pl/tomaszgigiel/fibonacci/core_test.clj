(ns pl.tomaszgigiel.fibonacci.core-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.fibonacci.core :as core])
  (:require [pl.tomaszgigiel.fibonacci.test-config :as test-config]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(tst/deftest ok-test
  (tst/is (= "ok" "ok")))
