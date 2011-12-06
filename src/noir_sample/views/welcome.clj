(ns noir-sample.views.welcome
  (:require [noir-sample.views.common :as common]
            [noir.content.getting-started])
  (:use noir.core
        hiccup.core
        hiccup.page-helpers))


(def clojure-func-and-vals ["*agent*" "accessor" "aclone" "add-classpath" "add-local-javadoc" "add-remote-javadoc" "add-watch" "agent" "agent-error" "agent-errors" "aget" "alength" "alias" "all-ns" "alter" "alter-meta!" "alter-var-root" "amap" "ancestors" "and" "append-child" "apply" "apply-template" "apropos" "are" "areduce" "array-map" "as-file" "as-relative-path" "as-url" "aset" "aset-boolean" "aset-byte" "aset-char" "aset-double" "aset-float" "aset-int" "aset-long" "aset-short" "assert" "assert-any" "assert-predicate" "assoc" "assoc!" "assoc-in" "associative?" "atom" "await" "await-for" "bases" "bean" "bigdec" "bigint" "binding" "bit-and" "bit-and-not" "bit-clear" "bit-flip" "bit-not" "bit-or" "bit-set" "bit-shift-left" "bit-shift-right" "bit-test" "bit-xor" "boolean" "boolean-array" "booleans" "bound-fn" "bound-fn*" "bound?" "branch?" "browse-url" "butlast" "byte" "byte-array" "bytes" "*clojure-version*" "*command-line-args*" "*compile-files*" "*compile-path*" "case" "cast" "char" "char-array" "char-escape-string" "char-name-string" "char?" "chars" "children" "cl-format" "class" "class?" "clear-agent-errors" "clojure-version" "code-dispatch" "Coercions" "coll?" "comment" "commute" "comp" "comparator" "compare" "compare-and-set!" "compile" "complement" "compose-fixtures" "concat" "cond" "condp" "conj" "conj!" "cons" "constantly" "construct-proxy" "contains?" "copy" "count" "counted?" "create-ns" "create-struct" "cycle" "dec" "decimal?" "declare" "definline" "defmacro" "defmethod" "defmulti" "defn" "defn-" "defonce" "defprotocol" "defrecord" "defstruct" "deftest" "deftest-" "deftype" "delay" "delay?" "delete-file" "deliver" "denominator" "deref" "derive" "descendants" "difference" "dir" "dir-fn" "disj" "disj!" "dissoc" "dissoc!" "distinct" "distinct?" "do-template" "doall" "doc" "dorun" "doseq" "dosync" "dotimes" "doto" "double" "double-array" "doubles" "down" "drop" "drop-last" "drop-while" "*e" "*err*" "e" "edit" "empty" "empty?" "end?" "ensure" "enumeration-seq" "error-handler" "error-mode" "eval" "even?" "every?" "extend" "extend-protocol" "extend-type" "extenders" "extends?" "*file*" "*flush-on-newline*" "false?" "ffirst" "file" "file-position" "file-seq" "filter" "find" "find-doc" "find-ns" "find-var" "first" "flatten" "float" "float-array" "float?" "floats" "flush" "fn" "fn?" "fnext" "fnil" "for" "force" "format" "formatter" "formatter-out" "frequencies" "fresh-line" "function?" "future" "future-call" "future-cancel" "future-cancelled?" "future-done?" "future?" "gen-class" "gen-interface" "gensym" "get" "get-in" "get-method" "get-possibly-unbound-var" "get-pretty-writer" "get-proxy-class" "get-thread-bindings" "get-validator" "group-by" "hash" "hash-map" "hash-set" "*in*" "identical?" "identity" "if-let" "if-not" "ifn?" "import" "in-ns" "inc" "inc-report-counter" "index" "init-proxy" "input-stream" "insert-child" "insert-left" "insert-right" "inspect" "inspect-table" "inspect-tree" "instance?" "int" "int-array" "integer?" "interleave" "intern" "interpose" "intersection" "into" "into-array" "ints" "io!" "IOFactory" "is" "isa?" "iterate" "iterator-seq" "javadoc" "join" "join-fixtures" "juxt" "keep" "keep-indexed" "key" "keys" "keyword" "keyword?" "keywordize-keys" "*load-tests*" "last" "lazy-cat" "lazy-seq" "left" "leftmost" "lefts" "let" "letfn" "line-seq" "list" "list*" "list?" "load" "load-file" "load-reader" "load-script" "load-string" "loaded-libs" "locking" "long" "long-array" "longs" "loop" "macroexpand" "macroexpand-1" "macroexpand-all" "main" "make-array" "make-hierarchy" "make-input-stream" "make-node" "make-output-stream" "make-parents" "make-reader" "make-writer" "map" "map-indexed" "map-invert" "map?" "mapcat" "max" "max-key" "memfn" "memoize" "merge" "merge-with" "meta" "methods" "min" "min-key" "mod" "*ns*" "name" "namespace" "namespace-munge" "neg?" "newline" "next" "next" "nfirst" "nil?" "nnext" "node" "not" "not-any?" "not-empty" "not-every?" "not=" "ns" "ns-aliases" "ns-imports" "ns-interns" "ns-map" "ns-name" "ns-publics" "ns-refers" "ns-resolve" "ns-unalias" "ns-unmap" "nth" "nthnext" "num" "number?" "numerator" "" "*out*" "object-array" "odd?" "or" "output-stream" "*print-base*" "*print-dup*" "*print-length*" "*print-level*" "*print-meta*" "*print-miser-width*" "*print-pprint-dispatch*" "*print-pretty*" "*print-radix*" "*print-readably*" "*print-right-margin*" "*print-suppress-namespace" "parents" "parse" "partial" "partition" "partition-all" "partition-by" "path" "pcalls" "peek" "persistent!" "pmap" "pop" "pop!" "pop-thread-bindings" "pos?" "postwalk" "postwalk-demo" "postwalk-replace" "pp" "pprint" "pprint-indent" "pprint-logical-block" "pprint-newline" "pprint-tab" "pr" "pr-str" "prefer-method" "prefers" "prev" "prewalk" "prewalk-demo" "prewalk-replace" "print" "print-cause-trace" "print-namespace-doc" "print-stack-trace" "print-str" "print-throwable" "print-trace-element" "printf" "println" "println-str" "prn" "prn-str" "project" "promise" "proxy" "proxy-mappings" "proxy-super" "push-thread-bindings" "pvalues" "quot" "*read-eval*" "rand" "rand-int" "rand-nth" "range" "ratio?" "rationalize" "re-find" "re-groups" "re-matcher" "re-matches" "re-pattern" "re-seq" "read" "read-line" "read-string" "reader" "reductions" "ref" "ref-history-count" "ref-max-history" "ref-min-history" "ref-set" "refer" "refer-clojure" "reify" "release-pending-sends" "rem" "remove" "remove" "remove-all-methods" "remove-method" "remove-ns" "remove-watch" "rename" "rename-keys" "repeat" "repeatedly" "repl" "repl-caught" "repl-exception" "repl-prompt" "repl-read" "replace" "replace" "replicate" "report" "require" "reset!" "reset-meta!" "resolve" "resource" "rest" "restart-agent" "resultset-seq" "reverse" "reversible?" "right" "rightmost" "rights" "root" "root-cause" "rseq" "rsubseq" "run-all-tests" "run-tests" "*stack-trace-depth*" "satisfies?" "second" "select" "select-keys" "send" "send-off" "seq" "seq-zip" "seq?" "seque" "sequence" "sequential?" "set" "set-error-handler!" "set-error-mode!" "set-pprint-dispatch" "set-test" "set-validator!" "set?" "sh" "short" "short-array" "shorts" "shuffle" "shutdown-agents" "simple-dispatch" "skip-if-eol" "skip-whitespace" "slurp" "some" "sort" "sort-by" "sorted-map" "sorted-map-by" "sorted-set" "sorted-set-by" "sorted?" "source" "source-fn" "special-form-anchor" "special-symbol?" "spit" "split-at" "split-with" "str" "string?" "stringify-keys" "struct" "struct-map" "subs" "subseq" "subset?" "subvec" "successful?" "supers" "superset?" "swap!" "symbol" "symbol?" "sync" "syntax-symbol-anchor" "take" "take-last" "take-nth" "take-while" "test" "test-all-vars" "test-ns" "test-var" "testing" "testing-contexts-str" "testing-vars-str" "the-ns" "thread-bound?" "time" "to-array" "to-array-2d" "trampoline" "transient" "tree-seq" "true?" "try-expr" "type" "unchecked-add" "unchecked-dec" "unchecked-divide" "unchecked-inc" "unchecked-multiply" "unchecked-negate" "unchecked-remainder" "unchecked-subtract" "underive" "union" "up" "update-in" "update-proxy" "use" "use-fixtures" "val" "vals" "var-get" "var-set" "var?" "vary-meta" "vec" "vector" "vector-of" "vector-zip" "vector?" "*warn-on-reflection*" "walk" "when" "when-first" "when-let" "when-not" "while" "with-bindings" "with-bindings" "with-bindings*" "with-in-str" "with-local-vars" "with-meta" "with-open" "with-out-str" "with-pprint-dispatch" "with-precision" "with-sh-dir" "with-sh-env" "with-test" "with-test-out" "write" "write-out" "writer" "xml-seq" "xml-zip" "zero?" "zipmap" "zipper" "ther" "*" "*1" "*2" "*3" "+" "-" "->" "->>" ".." "/" "<" "<=" "=" "==" ">" ">="])


(def programing-languages ["A# .NET" "A# (Axiom)" "A-0 System" "A+" "A++" "ABAP" "ABC" "ABC ALGOL" "Abel" "ABLE" "ABSET" "ABSYS" "Abundance" "ACC" "Accent" "Ace DASL" "ACT-III" "Action!" "ActionScript" "Ada" "Adenine" "Agda" "Agora" "AIMMS" "Alef" "ALF" "ALGOL 58" "ALGOL 60" "ALGOL 68" "Alice" "Alma-0" "AmbientTalk" "Amiga E" "AMOS" "AMPL" "APL" "AppleScript" "Arc" "ARexx" "Argus" "AspectJ" "Assembly language" "ATS" "Ateji PX" "AutoHotkey" "Autocoder" "AutoIt" "AutoLISP / Visual LISP" "Averest" "AWK" "Axum" "B" "Babbage" "Bash" "BASIC" "bc" "BCPL" "BeanShell" "Batch (Windows/Dos)" "Bertrand" "BETA" "Bigwig" "Bistro" "BitC" "BLISS" "Blue" "Bon" "Boo" "Boomerang" "Bourne shell (including bash and ksh)" "BREW" "BPEL" "BUGSYS" "BuildProfessional" "C" "C--" "C++ - ISO/IEC 14882" "C# - ISO/IEC 23270" "C/AL" "Caché ObjectScript" "C Shell" "Caml" "Candle" "Cayenne" "Cecil" "Cel" "Cesil" "CFML" "Cg" "Chapel" "CHAIN" "Charity" "Charm" "Chef" "CHILL" "CHIP-8" "chomski" "Oxygene (formerly Chrome)" "ChucK" "CICS" "Cilk" "CL (IBM)" "Claire" "Clarion" "Clean" "Clipper" "CLIST" "Clojure" "CLU" "CMS-2" "COBOL - ISO/IEC 1989" "CobolScript" "Cobra" "CODE" "CoffeeScript" "Cola" "ColdC" "ColdFusion" "Cool" "COMAL" "Combined Programming Language (CPL)" "Common Intermediate Language (CIL)" "Common Lisp (also known as CL)" "COMPASS" "Component Pascal" "COMIT" "Constraint Handling Rules (CHR)" "Converge" "Coral 66" "Corn" "CorVision" "Coq" "COWSEL" "CPL" "csh" "CSP" "Csound" "Curl" "Curry" "Cyclone" "Cython" "D" "DASL (Datapoint's Advanced Systems Language)" "DASL (Distributed Application Specification Language)" "Dart" "DataFlex" "Datalog" "DATATRIEVE" "dBase" "dc" "DCL" "Deesel (formerly G)" "Delphi" "DinkC" "DIBOL" "DL/I" "Draco" "Dylan" "DYNAMO" "E" "Ease" "EASY" "Easy PL/I" "EASYTRIEVE PLUS" "ECMAScript" "Edinburgh IMP" "EGL" "Eiffel" "ELAN" "Emacs Lisp" "Emerald" "Epigram" "Erlang" "Escapade" "Escher" "ESPOL" "Esterel" "Etoys" "Euclid" "Euler" "Euphoria" "EusLisp Robot Programming Language" "CMS EXEC" "EXEC 2" "F" "F#" "Factor" "Falcon" "Fancy" "Fantom" "Felix" "Ferite" "FFP" "Fjölnir" "FL" "Flavors" "Flex" "FLOW-MATIC" "FOCAL" "FOCUS" "FOIL" "FORMAC" "@Formula" "Forth" "Fortran - ISO/IEC 1539" "Fortress" "FoxBase" "FoxPro" "FP" "FPr" "Franz Lisp" "Frink" "F-Script" "Fuxi" "G" "GameMonkey Script" "GAMS" "GAP" "G-code" "Genie" "GDL" "Gibiane" "GJ" "GLSL" "GNU E" "GM" "Go" "Go!" "GOAL" "Gödel" "Godiva" "GOM (Good Old Mad)" "Goo" "GOTRAN" "GPSS" "GraphTalk" "GRASS" "Green" "Groovy" "HAL/S" "Hamilton C shell" "Harbour" "IBM HAScript" "Haskell" "HaXe" "High Level Assembly" "HLSL" "Hop" "Hope" "Hugo" "Hume" "HyperTalk" "IBM Basic assembly language" "IBM Informix-4GL" "IBM RPG" "ICI" "Icon" "Id" "IDL" "IMP" "Inform" "Io" "Ioke" "IPL" "IPTSCRAE" "ISPF" "ISWIM" "J" "J#" "J++" "JADE" "Jako" "JAL" "Janus" "JASS" "Java" "JavaScript" "JCL" "JEAN" "Join Java" "JOSS" "Joule" "JOVIAL" "Joy" "JScript" "Jython" "JavaFX Script" "K" "Kaleidoscope" "Karel" "Karel++" "Kaya" "KEE" "KIF" "KRC" "KRL" "KRL (KUKA Robot Language)" "KRYPTON" "ksh" "L" "L# .NET" "LabVIEW" "Ladder" "Lagoona" "LANSA" "Lasso" "LaTeX" "Lava" "LC-3" "Leadwerks Script" "Leda" "Legoscript" "LilyPond" "Limbo" "Limnor" "LINC" "Lingo" "Linoleum" "LIS" "LISA" "Lisaac" "Lisp - ISO/IEC 13816" "Lite-C Lite-c" "Lithe" "Little b" "Logo" "Logtalk" "LPC" "LSE" "LSL" "Lua" "Lucid" "Lustre" "LYaPAS" "Lynx" "M" "M2001" "M4" "Machine code" "MAD (Michigan Algorithm Decoder)" "MAD/I" "Magik" "Magma" "make" "Maple" "MAPPER (Unisys/Sperry) now part of BIS" "MARK-IV (Sterling/Informatics) now VISION:BUILDER of CA" "Mary" "MASM Microsoft Assembly x86" "Mathematica" "MATLAB" "Maxima (see also Macsyma)" "MaxScript internal language 3D Studio Max" "Maya (MEL)" "MDL" "Mercury" "Mesa" "Metacard" "Metafont" "MetaL" "Microcode" "MicroScript" "MIIS" "MillScript" "MIMIC" "Mirah" "Miranda" "MIVA Script" "ML" "Moby" "Model 204" "Modelica" "Modula" "Modula-2" "Modula-3" "Mohol" "MOO" "Mortran" "Mouse" "MPD" "MSIL - deprecated name for CIL" "MSL" "MUMPS" "Napier88" "NASM" "NATURAL" "NEAT chipset" "Neko" "Nemerle" "NESL" "Net.Data" "NetLogo" "NewLISP" "NEWP" "Newspeak" "NewtonScript" "NGL" "Nial" "Nice" "Nickle" "NPL" "Not eXactly C (NXC)" "Not Quite C (NQC)" "Nu" "NSIS" "o:XML" "Oak" "Oberon" "Object Lisp" "ObjectLOGO" "Object REXX" "Object Pascal" "Objective-C" "Objective Caml" "Objective-J" "Obliq" "Obol" "occam" "occam-π" "Octave" "OmniMark" "Onyx" "Opa" "Opal" "OpenEdge ABL" "OPL" "OPS5" "OptimJ" "Orc" "ORCA/Modula-2" "Orwell" "Oxygene" "Oz" "P#" "PARI/GP" "Pascal - ISO 7185" "Pawn" "PCASTL" "PCF" "PEARL" "PeopleCode" "Perl" "PDL" "PHP" "Phrogram" "Pico" "Pict" "Pike" "PIKT" "PILOT" "Pizza" "PL-11" "PL/0" "PL/B" "PL/C" "PL/I - ISO 6160" "PL/M" "PL/P" "PL/SQL" "PL360" "PLANC" "Plankalkül" "PLEX" "PLEXIL" "Plus" "POP-11" "PostScript" "PortablE" "Powerhouse" "PowerBuilder - 4GL GUI appl. generator from Sybase" "PPL" "Processing" "Prograph" "PROIV" "Prolog" "Visual Prolog" "Promela" "PROTEL" "ProvideX" "Pro*C" "Pure" "Python" "Q (equational programming language)" "Q (programming language from Kx Systems)" "Qi" "QtScript" "QuakeC" "QPL" "R" "R++" "Racket" "RAPID" "Rapira" "Ratfiv" "Ratfor" "rc" "REBOL" "Redcode" "REFAL" "Reia" "Revolution" "rex" "REXX" "Rlab" "ROOP" "RPG" "RPL" "RSL" "RTL/2" "Ruby" "Rust" "S" "S2" "S3" "S-Lang" "S-PLUS" "SA-C" "SabreTalk" "SAIL" "SALSA" "SAM76" "SAS" "SASL" "Sather" "Sawzall" "SBL" "Scala" "Scheme" "Scilab" "Scratch" "Script.NET" "Sed" "Self" "SenseTalk" "SETL" "Shift Script" "SiMPLE" "SIMPOL" "SIMSCRIPT" "Simula" "Simulink" "SISAL" "SLIP" "SMALL" "Smalltalk" "Small Basic" "SML" "SNOBOL(SPITBOL)" "Snowball" "SOAP" "SOL" "Span" "SPARK" "SPIN" "SP/k" "SPS" "Squeak" "Squirrel" "SR" "S/SL" "Strand" "STATA" "Stateflow" "Subtext" "Suneido" "SuperCollider" "SuperTalk" "SYMPL" "SyncCharts" "SystemVerilog" "T" "TACL" "TACPOL" "TADS" "TAL" "Tcl" "Tea" "TECO" "TELCOMP" "TeX" "TEX" "TIE" "Timber" "Tom" "TOM" "Topspeed" "TPU" "Trac" "T-SQL" "TTCN" "Turing" "TUTOR" "TXL" "Ubercode" "Unicon" "Uniface" "UNITY" "Unix shell" "UnrealScript" "Vala" "VBA" "VBScript" "Verilog" "VHDL" "Visual Basic" "Visual Basic .NET" "Visual C++" "Visual C++ .Net" "Visual C#" "Visual DataFlex" "Visual DialogScript" "Visual FoxPro" "Visual J++" "Visual J#" "Visual Objects" "VSXu" "Vvvv" "WATFIV, WATFOR" "WebQL" "Winbatch" "X++" "X10" "XBL" "XC (exploits XMOS architecture)" "xHarbour" "XL" "XOTcl" "XPL" "XPL0" "XQuery" "XSB" "XSLT - See XPath" "Yorick" "YQL" "Yoix" "Z" "Z notation" "Zeno" "ZOPL" "ZPL" "ZZT-oop"])


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
   [:h2 "眠い"]
   [:ul
    [:li (link-to "/num-seq" "num-seq(0~10)")]
    [:li (link-to "/alpha-seq" "alp-seq(a~z)")]
    [:li (link-to "/orenoimouto" "orenoimouto (using Web API sample)") ]
    [:li (link-to "/programing-languages" "Programing languages and it's image") ]
    [:li (link-to "/clojure-func" "clojure func and vals") ]]))

;; can't use in hekeru?
(defpage "/" []
 (jpg-to-page-seq (range 11)))

(defpage "/num-seq" []
  (jpg-to-page-seq (range 101)))

(defpage "/alpha-seq" []
  (jpg-to-page-seq (map char (range 97 123))))

(defpage "/clojure-func" []
   (common/layout
    [:h1 "clojure func and vals"]
    [:ul
     (map common/link-jpg-to-src clojure-func-and-vals)]))

(defpage "/programing-languages" []
   (common/layout
    [:h1 "programing languages and it's image"]
    [:ul
     (map common/link-jpg-to-src programing-languages)]))


