(ns leiningen.new.david-template
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "david-template"))

(defn david-template
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' david-template project.")
    (->files data
             ["LICENSE" (render "LICENSE" data)]
             ["Procfile" (render "Procfile" data)]
             ["README.md" (render "README.md" data)]
             ["project.clj" (render "project.clj" data)]
             ["system.properties" (render "system.properties" data)]
             [".gitignore" (render "gitignore" data)]

             ["dev/user.clj" (render "dev/user.clj" data)]

             ["features/test.feature" (render "features/test.feature" data)]
             ["features/step_definitions/features.clj" (render "features/step_definitions/features.clj" data)]
             ["features/step_definitions/test_steps.clj" (render "features/step_definitions/test_steps.clj" data)]

             ["resources/log4j.properties" (render "resources/log4j.properties" data)]
             ["resources/public/index.html" (render "resources/public/index.html" data)]

             ["src/clj/{{sanitized}}/server.clj" (render "src/clj/david_template/server.clj" data)]
             ["src/cljc/{{sanitized}}/common.cljc" (render "src/cljc/david_template/common.cljc" data)]
             ["src/cljs/{{sanitized}}/core.cljs" (render "src/cljs/david_template/core.cljs" data)]
             ["src/scss/style.scss" (render "src/scss/style.scss" data)]

             ["test/clj/{{sanitized}}/example_test.clj" (render "test/clj/david_template/example_test.clj" data)]
             ["test/cljc/{{sanitized}}/common_test.cljc" (render "test/cljc/david_template/common_test.cljc" data)]
             ["test/cljs/{{sanitized}}/core_test.cljs" (render "test/cljs/david_template/core_test.cljs" data)]
             ["test/cljs/{{sanitized}}/test_runner.cljs" (render "test/cljs/david_template/test_runner.cljs" data)])))

