(ns todo.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [todo.core-test]
   [todo.common-test]))

(enable-console-print!)

(doo-tests 'todo.core-test
           'todo.common-test)
