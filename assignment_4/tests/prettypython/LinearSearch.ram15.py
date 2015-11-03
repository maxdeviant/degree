class LS():
    def Start(self, sz):
        aux01 = self.Init(sz)
        aux02 = self.Print()
        print 9999
        print self.Search(8)
        print self.Search(12)
        print self.Search(17)
        print self.Search(50)
        return 55

    def Print(self):
        j = 1
        while j < size:
            print number[j]
            j += 1

        return 0

    def Search(self, num):
        j = 1
        ls01 = False
        ifound = 0
        while j < size:
            aux01 = number[j]
            aux02 = num + 1
            if aux01 < num:
                nt = 0
            else:
                if not aux01 < aux02:
                    nt = 0
                else:
                    ls01 = True
                    ifound = 1
                    j = size



            j = j + 1

        return ifound

    def Init(self, sz):
        size = sz
        number = []
        j = 1
        k = size + 1
        while j < size:
            aux01 = 2 * j
            aux02 = k - 3
            number[j] = aux01 + aux02
            j += 1
            k = k - 1

        return 0


if __name__ == '__main__':
    print LS().Start(10)
