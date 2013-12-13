#Test 3 Review

##Timing Efficiency
Algorithm | Stable | Best Time | Average Time | Worst Time | Extra Memory
:-------: | :----: | :-------: | :----------: | :--------: | :---------:
Selection Sort | No | `O(n^2)` | `O(n^2)` | `O(n^2)` | `O(1)`
Insertion Sort | Yes | `O(n)` | `O(n^2)` | `O(n^2)` | `O(1)`
Shell Sort | No | `O(n * log(n))` | `O(n^1.25)†` | `O(n^1.5)` | `O(1)`
Quick Sort | No | `O(n * log(n))` | `O(n * log(n))` | `O(n^2)` | `O(log(n))`
Merge Sort | Yes | `O(n * log(n))` | `O(n * log(n))` | `O(n * log(n))` | `O(n)`
Heap Sort | No | `O(n)` | `O(n * log(n))` | `O(n * log(n))` | `O(1)`

`† conjectured`

##Selection Sort

```javascript
function selection_sort(a) {
    for (var i = 0; i < a.length; i++) {
        var min = i;
        
        for (var j = i + 1; j < a.length; j++) {
            if (a[j] < a[min]) {
                min = j;
            }
        }
        
        if (min === i) {
            swap(a[i], a[min]);
        }
    }
}

function swap(a, b) {
    var temp = a;
    a = b;
    b = temp;
}
```

##Insertion Sort

```javascript
function insertion_sort(a) {
    for (var i = 1; i < a.length; i++) {
        var insert = a[i];
        var hole = i;
        
        while (hole > 0 && insert < a[hole - 1]) {
            a[hole] = a[hole - 1];
            hole = hole - 1;
        }
        
        a[hole] = insert;
    }
}
```

##Shell Sort

```javascript

```

##Quick Sort

```javascript
var CUTOFF = 10;

function quick_sort(a, from, to) {
    if (to - from <= CUTOFF) {
        insertion_sort(a);
    }
}
```

##Merge Sort

```javascript
function merge_sort(a, from, mid, to) {
    if (a.length === 1) {
        return;
    }
    
    
}
```

##Heap Sort

```javascript
function heap_sort(a) {
    build_heap(a);
    
    var end = a.length - 1;
    
    while (end > 0) {
        swap (a[end], a[0]);
        end = end - 1;
        sift_up(a, 0, end);
    }
}

function build_heap(a) {
    var end = 1;
    var count = a.length;
    
    while (end < count) {
        sift_up(a, 0, end);
        end = end + 1;
    }
}

function sift_up(a, start, end) {
    var child = end;
    
    while (child > start) {
        parent = Math.floor((child - 1) / 2);
        
        if (a[parent] < a[child]) {
            swap(a[parent], a[child]);
            child = parent;
        } else { 
            return;
        }
    }
}

function swap(a, b) {
    var temp = a;
    a = b;
    b = temp;
}
```
