(require '[{{name}}.pages.index :as page])

(When #"^The user enters '(.+)' into the name field$" [name]
  (page/enter-name name))

(Then #"^The greeting should be '(.+)'$" [expected]
  (let [actual (page/greeting)]
    (assert (= expected (page/greeting))
            (str "Expected greeting to be " expected
                 ", was " actual))))
