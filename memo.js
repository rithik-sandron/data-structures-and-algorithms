// fibnacci series with recursion and memorization
const fib = (n, cache = { 0: 0, 1: 1, 2: 1 }) => {
    if (cache.hasOwnProperty(+n)) return cache[n];
    cache[n] = fib(n - 1, cache) + fib(n - 2, cache);
    return cache[n];
};

// path algorithm with rexursion and memorization
const traverse = (m, n, cache = {}, validPath = {}) => {
    if (m === 1 && n === 1) return 1;
    if (m === 0 || n === 0) return 0;
    let path = m + ',' + n;
    if (cache.hasOwnProperty(path)) return cache[path];
    cache[path] = traverse(m - 1, n, cache) + traverse(m, n - 1, cache);
    return cache[path];
};

console.log(traverse(10, 10));
