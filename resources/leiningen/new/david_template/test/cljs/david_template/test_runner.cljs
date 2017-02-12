(ns {{name}}.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [{{name}}.core-test]
   [{{name}}.common-test]))

(enable-console-print!)

(doo-tests '{{name}}.core-test
           '{{name}}.common-test)
