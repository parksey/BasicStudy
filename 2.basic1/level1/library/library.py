dictionary={}

def insertion():
    while True:
        try:
            print("책 제목, 지은이, 출판사, 수량 순으로 입력해 주세요.")
            insert = input()
            value = insert.split(', ')
            key=value[0]+", "+value[1]
            val=insert
            dictionary[key]=val
            return False
        except:
            print("[Error]")

def deletion():
    while True:
        try:
            print("삭제하고자 하는 책의 제목과 지은이를 입력해주세요.")
            insert= input()
            if insert in dictionary:
                dictionary.pop(insert)
                return False
        except:
            print("[Error]")
        
    

def checkStatus():
    print("도서관 내의 도서 리스트")
    print("="*3)
    bookList=list(dictionary.values())
    print(*bookList)

if __name__ =="__main__":            

    print("도서관 프로그램입니다.")
    while True:
        try:
            print("책을 추가하려면(1), 삭제하려면(2), 책 리스트 확인(3)를 입력하세요")
            menuInput=input()

            if menuInput is "1":
                insertion()
                
            if menuInput is "2":
                deletion()
                
            if menuInput is "3":
                checkStatus()
            if menuInput=="QUIT":
                print("도서관 프로그램을 종료합니다.")
                break
        except ValueError: 
            print("[Error]")