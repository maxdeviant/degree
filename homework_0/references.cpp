#include <iostream>

using namespace std;

int square(int& i);
int twice(int& i);
int once(int& i);

int main() {
    int x = 3;
    int y = square(x) + twice(x) + once(x);
    cout << y << endl;
}

int square(int& i) {
    return i = i * i;
}

int twice(int& i) {
    return i = 2 * i;
}

int once(int& i) {
    return i;
}