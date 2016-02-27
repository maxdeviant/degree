class Arrays():

    def run(self):
        list = [None] * 5
        i = 0
        while i < 5:
            list[i] = i + 1
            i += 1

        a = list[1:3]
        b = list[2:]
        c = list[:3]
        d = list[:]
        print len(a)
        print len(b)
        print len(c)
        print len(d)
        lengthA = len(a)
        print lengthA
        return True


if __name__ == '__main__':
    print Arrays().run()
