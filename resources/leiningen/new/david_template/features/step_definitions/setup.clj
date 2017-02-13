(require '[{{name}}.pages.core :refer [setup teardown]])

(Before [] (setup))
(After [] (teardown))
