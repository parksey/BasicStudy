class Library:
    def __init__(self):    
        self.libraryDict = {}#회원 이름과 핸드폰 번호를 포함한 dictionary
        self.libraryList = []#책 이름과 지은이를 포함한 LIST
        self.userDict = {}#책을 빌린 회원이 있는 dictionary

    def addMember(self):
            try:
                print("추가할 회원의 이름과 핸드폰 번호를 입력하세요.")
                new = input().split(", ")
                key = new[0] + ", " + new[1]#입력값을 ", "로서 항상 콤마 후에 띄어쓰기로 저장
                val = key
                self.libraryDict[key] = val #libraryDict 에 key 와 val를 같은값 부여
            except:
                print("[Error]")
            
    def deleteMember(self):
            try:
                print("삭제하고자 하는 회원의 이름과 핸드폰 번호를 입력하세요.")
                delete = input().split(", ")
                key = delete[0] + ", " + delete[1]
                if key in self.userDict: 
                    print("해당 회원은 대여 중인 책이 존재하여 삭제할 수 없습니다.")
                elif key in self.libraryDict:#대여중인 책이 없는 회원
                    self.libraryDict.pop(key)
                    print("삭제 완료 하였습니다.")
                else:
                    print("해당 회원은 등록되어 있지 않습니다.")
            except:
                print("[Error]")
                
    def rentSystem(self):
            try:
                print("대여할 사람의 핸드폰 번호와 이름을 입력하세요.")
                rent = input().split(", ")
                key = rent[0] + ", " + rent[1]
                if key not in self.libraryDict:#등록되어 있지 않은 회원일시
                    print("등록되어 있지 않은 회원입니다.")
                else:
                    print("책의 이름과 지은이를 선택하세요.")
                    bookRequest = input().split(", ")
                    val = bookRequest[0] + ", " + bookRequest[1]
                    if val not in self.libraryList:#누군가에게 빌려진 책이 아닐시
                        self.userDict[key] = val
                        self.libraryList.append(val)
                        print("대여에 성공했습니다.")
                    else:
                        print("해당 책을 대여할 수 없습니다.")
            except:
                print("[Error]")
        
    def runLibrary(self):                
        print("도서관 프로그램입니다.")
        while True:
            try:
                print("회원 추가(1), 회원 삭제(2), 책 대여(3) 중 선택하세요.")
                numberInput = input()
                if numberInput == "1":
                    self.addMember()
                    
                elif numberInput == "2":
                    self.deleteMember()
                    
                elif numberInput =="3":
                    self.rentSystem()
                    
                elif numberInput == "QUIT":
                    print("도서관 프로그램을 종료합니다.")
                    break
                else:
                    raise ValueError
            except ValueError:
                print("[Error]")    
            except:
                print("[Error]")
                
            
                
run=Library()
run.runLibrary()