# Development
## Benchmarking
The benchmark suite measures the performance of Pine's core functionality. It is available for the JVM and JavaScript back ends.

The benchmarks can be run on the JVM as follows:

```shell
bloop run pine-bench-jvm -- fast  # Fast profile
bloop run pine-bench-jvm -- slow  # Slow profile
```

The JavaScript suite requires two dependencies to be installed:

```shell
yarn add jsdom object-sizeof
```

If you are compiling to tmpfs, link the `node_modules` folder:

```shell
ln -s $(pwd)/node_modules /tmp/build-pine/node_modules
```

Then, run the suite with Node.js:

```
bloop run pine-bench-js -- fast  # Fast profile
bloop run pine-bench-js -- slow  # Slow profile
```

Since Node.js is lacking a DOM implementation, several benchmarks will be omitted. However, you can run the full benchmark suite in the browser. This requires the webpack dependency:

```shell
yarn add webpack webpack-cli
```

Next, create an HTML file in the build folder (e.g. `/tmp/build-pine/`):

```html
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<script src="main.js"></script>
	</body>
</html>
```

And the webpack configuration `webpack.config.js`:

```javascript
const path = require('path');

module.exports = {
  entry: './pine-bench.js',
  output: {
    filename: 'main.js',
    path: __dirname
  }
};
```

Finally, link the benchmark suite and bundle all external dependencies into a single JavaScript file:

```shell
bloop link pine-bench-js
yarn exec webpack --config webpack.config.js
```

You can now open the HTML file in the browser. The results will be printed to the browser console.

To detect performance regressions, the benchmarks are run with JVM and Node.js as part of every CI build. Since the benchmark suite uses the fast profile to speed up CI runs, it is advisable to also run the benchmarks locally in the `slow` profile. Similarly, the DOM benchmarks are not run as part of CI and should be tested manually in a browser.
