class Loops():

    def run(self):
        list = [None] * 10
        i = 0
        while i < 10:
            list[i] = i * i
            i += 1

        power = 0
        while power < 9000:
            power += 1
            print power

        return True


if __name__ == '__main__':
    print Loops().run()
