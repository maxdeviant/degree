#Test 3 Review

##Timing Efficiency
Algorithm | Stable | Best Time | Average Time | Worst Time | Extra Memory
:-------: | :----: | :-------: | :----------: | :--------: | :---------:
Selection Sort | No | `O(n^2)` | `O(n^2)` | `O(n^2)` | `O(1)`
Insertion Sort | Yes | `O(n)` | `O(n^2)` | `O(n^2)` | `O(1)`
Shell Sort | No | `O(n * log(n))` | `O(n^1.25)` | `O(n^1.5)` | `O(1)`
Quick Sort | No | `O(n * log(n))` | `O(n * log(n))` | `O(n^2)` | `O(log(n))`
Merge Sort | Yes | `O(n * log(n))` | `O(n * log(n))` | `O(n * log(n))` | `O(n)`
Heap Sort | No | `O(n)` | `O(n * log(n))` | `O(n * log(n))` | `O(1)`

##Selection Sort

```
for (var i = 0; i < a.length; i++) {
    var min = i;
    
    for (var j = i + 1; j < a.length; j++) {
        if (a[j] < a[min]) {
            min = j;
        }
    }
    
    if (min == i) {
        swap(a[i], a[min]);
    }
}

function swap(a, b) {
    var temp = a;
    a = b;
    b = temp;
}
```

##Insertion Sort

```
for (var i = 1; i < a.length; i++) {
    var insert = a[i];
    var hole = i;
    
    while (hole > 0 && insert < a[hole - 1]) {
        a[hole] = a[hole - 1];
        hole = hole - 1;
    }
    
    a[hole] = insert;
}
```

##Shell Sort

##Quick Sort

##Merge Sort

##Heap Sort