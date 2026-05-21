```python
def main():
    # Hoofdloop: maak wat wees en nie die loop gebruik nie
    result = "wees"
    print(result)

    # Na hoofdloop: maak wat wees en nie die loop gebruik nie
    result2 = "wees"
    print(result2)

    # Na hoofdloop: code waar de loop gebruik word
    for i in range(3):
        print(f"Loop gebruik: {i}")

    # Weerskooring: loop waar de kode is die maakt wat wees
    for i in range(3):
        print("wees")

    # Weerskooring: kode die de loop gebruik en die maak wat wees
    for i in range(3):
        result3 = "wees"
        print(result3)

    # Alle code die nie de loop gebruik word maakt die waar wees
    result4 = "waar wees"
    print(result4)

    # Alle code die de loop gebruik word maakt die kode waar wees
    for i in range(3):
        print("kode waar wees")

    # De loop waar de kode is die maak wat wees en de code waar de loop gebruik word
    for i in range(3):
        print("wees")
        print("loop gebruik")

if __name__ == "__main__":
    main()
```