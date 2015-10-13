# rum-figwheel-fireplace

This is an example application for using
[figwheel](https://github.com/bhauman/lein-figwheel)
with
[vim-fireplace](https://github.com/tpope/vim-fireplace)
after the 0.4 changes, that now leave out nREPL.

Note right now, this needs a [patched version of
fireplace](https://github.com/tpope/vim-fireplace/pull/222)

No template is complete, without an react wrapper, so
[rum](https://github.com/tonsky/rum) was chosen.

start figwheel in one terminal

    $ lein figwheel

Open the [http://localhost:3449/](http://localhost:3449/)

in another terminal start vim

    $ vim src/app/core.cljs

in vim connect to figwheel

    :Piggieback! (do (require 'figwheel-sidecar.repl-api) (figwheel-sidecar.repl-api/cljs-repl))

Now change either the hiccup or run or swap the state.
