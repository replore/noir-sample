(ns noir-sample.views.welcome
  (:require [noir-sample.views.common :as common]
            [noir.content.getting-started])
  (:use noir.core
        hiccup.core
        hiccup.page-helpers))


(def clojure-func-and-vals ["*agent*" "accessor" "aclone" "add-classpath" "add-local-javadoc" "add-remote-javadoc" "add-watch" "agent" "agent-error" "agent-errors" "aget" "alength" "alias" "all-ns" "alter" "alter-meta!" "alter-var-root" "amap" "ancestors" "and" "append-child" "apply" "apply-template" "apropos" "are" "areduce" "array-map" "as-file" "as-relative-path" "as-url" "aset" "aset-boolean" "aset-byte" "aset-char" "aset-double" "aset-float" "aset-int" "aset-long" "aset-short" "assert" "assert-any" "assert-predicate" "assoc" "assoc!" "assoc-in" "associative?" "atom" "await" "await-for" "bases" "bean" "bigdec" "bigint" "binding" "bit-and" "bit-and-not" "bit-clear" "bit-flip" "bit-not" "bit-or" "bit-set" "bit-shift-left" "bit-shift-right" "bit-test" "bit-xor" "boolean" "boolean-array" "booleans" "bound-fn" "bound-fn*" "bound?" "branch?" "browse-url" "butlast" "byte" "byte-array" "bytes" "*clojure-version*" "*command-line-args*" "*compile-files*" "*compile-path*" "case" "cast" "char" "char-array" "char-escape-string" "char-name-string" "char?" "chars" "children" "cl-format" "class" "class?" "clear-agent-errors" "clojure-version" "code-dispatch" "Coercions" "coll?" "comment" "commute" "comp" "comparator" "compare" "compare-and-set!" "compile" "complement" "compose-fixtures" "concat" "cond" "condp" "conj" "conj!" "cons" "constantly" "construct-proxy" "contains?" "copy" "count" "counted?" "create-ns" "create-struct" "cycle" "dec" "decimal?" "declare" "definline" "defmacro" "defmethod" "defmulti" "defn" "defn-" "defonce" "defprotocol" "defrecord" "defstruct" "deftest" "deftest-" "deftype" "delay" "delay?" "delete-file" "deliver" "denominator" "deref" "derive" "descendants" "difference" "dir" "dir-fn" "disj" "disj!" "dissoc" "dissoc!" "distinct" "distinct?" "do-template" "doall" "doc" "dorun" "doseq" "dosync" "dotimes" "doto" "double" "double-array" "doubles" "down" "drop" "drop-last" "drop-while" "*e" "*err*" "e" "edit" "empty" "empty?" "end?" "ensure" "enumeration-seq" "error-handler" "error-mode" "eval" "even?" "every?" "extend" "extend-protocol" "extend-type" "extenders" "extends?" "*file*" "*flush-on-newline*" "false?" "ffirst" "file" "file-position" "file-seq" "filter" "find" "find-doc" "find-ns" "find-var" "first" "flatten" "float" "float-array" "float?" "floats" "flush" "fn" "fn?" "fnext" "fnil" "for" "force" "format" "formatter" "formatter-out" "frequencies" "fresh-line" "function?" "future" "future-call" "future-cancel" "future-cancelled?" "future-done?" "future?" "gen-class" "gen-interface" "gensym" "get" "get-in" "get-method" "get-possibly-unbound-var" "get-pretty-writer" "get-proxy-class" "get-thread-bindings" "get-validator" "group-by" "hash" "hash-map" "hash-set" "*in*" "identical?" "identity" "if-let" "if-not" "ifn?" "import" "in-ns" "inc" "inc-report-counter" "index" "init-proxy" "input-stream" "insert-child" "insert-left" "insert-right" "inspect" "inspect-table" "inspect-tree" "instance?" "int" "int-array" "integer?" "interleave" "intern" "interpose" "intersection" "into" "into-array" "ints" "io!" "IOFactory" "is" "isa?" "iterate" "iterator-seq" "javadoc" "join" "join-fixtures" "juxt" "keep" "keep-indexed" "key" "keys" "keyword" "keyword?" "keywordize-keys" "*load-tests*" "last" "lazy-cat" "lazy-seq" "left" "leftmost" "lefts" "let" "letfn" "line-seq" "list" "list*" "list?" "load" "load-file" "load-reader" "load-script" "load-string" "loaded-libs" "locking" "long" "long-array" "longs" "loop" "macroexpand" "macroexpand-1" "macroexpand-all" "main" "make-array" "make-hierarchy" "make-input-stream" "make-node" "make-output-stream" "make-parents" "make-reader" "make-writer" "map" "map-indexed" "map-invert" "map?" "mapcat" "max" "max-key" "memfn" "memoize" "merge" "merge-with" "meta" "methods" "min" "min-key" "mod" "*ns*" "name" "namespace" "namespace-munge" "neg?" "newline" "next" "next" "nfirst" "nil?" "nnext" "node" "not" "not-any?" "not-empty" "not-every?" "not=" "ns" "ns-aliases" "ns-imports" "ns-interns" "ns-map" "ns-name" "ns-publics" "ns-refers" "ns-resolve" "ns-unalias" "ns-unmap" "nth" "nthnext" "num" "number?" "numerator" "" "*out*" "object-array" "odd?" "or" "output-stream" "*print-base*" "*print-dup*" "*print-length*" "*print-level*" "*print-meta*" "*print-miser-width*" "*print-pprint-dispatch*" "*print-pretty*" "*print-radix*" "*print-readably*" "*print-right-margin*" "*print-suppress-namespace" "parents" "parse" "partial" "partition" "partition-all" "partition-by" "path" "pcalls" "peek" "persistent!" "pmap" "pop" "pop!" "pop-thread-bindings" "pos?" "postwalk" "postwalk-demo" "postwalk-replace" "pp" "pprint" "pprint-indent" "pprint-logical-block" "pprint-newline" "pprint-tab" "pr" "pr-str" "prefer-method" "prefers" "prev" "prewalk" "prewalk-demo" "prewalk-replace" "print" "print-cause-trace" "print-namespace-doc" "print-stack-trace" "print-str" "print-throwable" "print-trace-element" "printf" "println" "println-str" "prn" "prn-str" "project" "promise" "proxy" "proxy-mappings" "proxy-super" "push-thread-bindings" "pvalues" "quot" "*read-eval*" "rand" "rand-int" "rand-nth" "range" "ratio?" "rationalize" "re-find" "re-groups" "re-matcher" "re-matches" "re-pattern" "re-seq" "read" "read-line" "read-string" "reader" "reductions" "ref" "ref-history-count" "ref-max-history" "ref-min-history" "ref-set" "refer" "refer-clojure" "reify" "release-pending-sends" "rem" "remove" "remove" "remove-all-methods" "remove-method" "remove-ns" "remove-watch" "rename" "rename-keys" "repeat" "repeatedly" "repl" "repl-caught" "repl-exception" "repl-prompt" "repl-read" "replace" "replace" "replicate" "report" "require" "reset!" "reset-meta!" "resolve" "resource" "rest" "restart-agent" "resultset-seq" "reverse" "reversible?" "right" "rightmost" "rights" "root" "root-cause" "rseq" "rsubseq" "run-all-tests" "run-tests" "*stack-trace-depth*" "satisfies?" "second" "select" "select-keys" "send" "send-off" "seq" "seq-zip" "seq?" "seque" "sequence" "sequential?" "set" "set-error-handler!" "set-error-mode!" "set-pprint-dispatch" "set-test" "set-validator!" "set?" "sh" "short" "short-array" "shorts" "shuffle" "shutdown-agents" "simple-dispatch" "skip-if-eol" "skip-whitespace" "slurp" "some" "sort" "sort-by" "sorted-map" "sorted-map-by" "sorted-set" "sorted-set-by" "sorted?" "source" "source-fn" "special-form-anchor" "special-symbol?" "spit" "split-at" "split-with" "str" "string?" "stringify-keys" "struct" "struct-map" "subs" "subseq" "subset?" "subvec" "successful?" "supers" "superset?" "swap!" "symbol" "symbol?" "sync" "syntax-symbol-anchor" "take" "take-last" "take-nth" "take-while" "test" "test-all-vars" "test-ns" "test-var" "testing" "testing-contexts-str" "testing-vars-str" "the-ns" "thread-bound?" "time" "to-array" "to-array-2d" "trampoline" "transient" "tree-seq" "true?" "try-expr" "type" "unchecked-add" "unchecked-dec" "unchecked-divide" "unchecked-inc" "unchecked-multiply" "unchecked-negate" "unchecked-remainder" "unchecked-subtract" "underive" "union" "up" "update-in" "update-proxy" "use" "use-fixtures" "val" "vals" "var-get" "var-set" "var?" "vary-meta" "vec" "vector" "vector-of" "vector-zip" "vector?" "*warn-on-reflection*" "walk" "when" "when-first" "when-let" "when-not" "while" "with-bindings" "with-bindings" "with-bindings*" "with-in-str" "with-local-vars" "with-meta" "with-open" "with-out-str" "with-pprint-dispatch" "with-precision" "with-sh-dir" "with-sh-env" "with-test" "with-test-out" "write" "write-out" "writer" "xml-seq" "xml-zip" "zero?" "zipmap" "zipper" "ther" "*" "*1" "*2" "*3" "+" "-" "->" "->>" ".." "/" "<" "<=" "=" "==" ">" ">="])


(defn convert-jpg-to-URL [name]
  (str "http://" name ".jpg.to"))

(defpartial jpg-to-page [name]
  (common/layout
   [:h1 (str name)]
   [:img {"src" (convert-jpg-to-URL name)}]))


(defpartial link-jpg-to-src [name]
  [:li name]
  [:li
   [:img {"src" (convert-jpg-to-URL (str name))}]])



(defpartial jpg-to-page-some-seq-page []
   (common/layout
    [:h1 "0~100 image(jpg.to)"]
    [:ul
     (map link-jpg-to-src (range 101))
     ]))


;; defpage

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to my sample"]))


(defpage "/jpgto/:name" {:keys [name]}
  (jpg-to-page name))

;; (defpage "/:name" {:keys [name]}
;;    (jpg-to-page name))

(defpage "/ohoho" []
  (common/layout
   [:h1 "ohoho"]))

;;(defpage "/" []
;;   (resp/redirect "/ohoho"))

(defpartial jpg-to-page-seq [seq]
   (common/layout
    [:ul
     (map common/link-jpg-to-src seq)
     ]))


(defpage "/sample" []
  (common/layout
   [:h1 "Sample noir Page (mainly using jpg.to)"]
   [:ul
    [:li (link-to "/num-seq" "num-seq(0~10)")]
    [:li (link-to "/alpha-seq" "alp-seq(a~z)")]
    [:li (link-to "/clojure-func" "clojure func and vals") ]]))

;; can't use in hekeru?
;; (defpage "/" []
;; (jpg-to-page-seq (range 11)))

(defpage "/num-seq" []
  (jpg-to-page-seq (range 101)))

(defpage "/alpha-seq" []
  (jpg-to-page-seq (map char (range 97 123))))

(defpage "/clojure-func" []
   (common/layout
    [:h1 "clojure func and vals"]
    [:ul
     (map common/link-jpg-to-src clojure-func-and-vals)]))

