import random

class MenuRecommendation:
    def __init__(self):

        self.japanese=["규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"]
        self.korean=["김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"]
        self.chinese=["깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"]
        self.asian=["팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"]
        self.western=["라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"]
        self.choicesList=["한식", "양식", "중식", "일식", "아시안", "양식"]
        self.dayList=["월요일", "화요일", "수요일", "목요일", "금요일"]
        self.oneCannot=[]
        self.smt=[]
        self.allMenu=self.japanese + self.korean + self.chinese + self.asian + self.western
        
    def askName(self):
        self.coachList=[]
        while True:
            try:
                print("코치의 이름을 입력해 주세요. (, 로 구분)")
                self.names=input().replace(" ", "")
                self.names=self.names.split(",")
                
                if len(self.names)>1 and len(self.names)<6:
                    for i in range (len(self.names)):
                        self.coachList.append(self.names[i])
                    # print(self.coachList)
                    return False
                
                else: raise ValueError
                
            except ValueError:
                print("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.")
            except:
                print("[ERROR]")
                
             
    def notEdible(self):
        self.cannotEat={}
        while True:
                try: 
                    for name in self.coachList:
                        print(name+"(이)가 못먹는 메뉴를 입력해 주세요.")
                        self.menu = input()
                        if not self.menu:
                            self.cannotEat[name] = None
                        else:
                            # self.menu = self.menu.replace(" ", "")
                            self.menuSplit=self.menu.split(",")
                        
                            for i in range (len(self.menuSplit)):
                                if self.menuSplit[i] not in self.allMenu:
                                    raise ValueError
                        
                                else:
                                    self.cannotEat[name]=self.menuSplit
                                    self.smt.append(self.menuSplit)
                        # print(self.cannotEat)
                    return False
                    
                except ValueError:
                    self.names={}
                    print("[ERROR]")
                except:
                    self.names={}
                    print("[ERROR1]")
     

    def randomChoice(self):
        self.categoryList=[]
        while len(self.categoryList) < 5:
            randomC = random.choice(self.choicesList)
            if self.choicesList.count(randomC) < 2 and self.categoryList.count(randomC) < 2:
                self.categoryList.append(randomC)
        print(self.categoryList)
                  
                
    def recommend(self):
        for type in self.categoryList:
            if type=="한식":
                a=random.choice(self.korean)
                self.coachEating.append(a)
                self.korean.remove(a)
            if type=="일식":
                b=random.choice(self.japanese)
                self.coachEating.append(b)
                self.japanese.remove(b)
            if type=="중식":
                c=random.choice(self.chinese)
                self.coachEating.append(c)
                self.chinese.remove(c)
            if type=="양식":
                d=random.choice(self.western)
                self.coachEating.append(d)
                self.western.remove(d)
            if type=="아시안":    
                e=random.choice(self.asian)
                self.coachEating.append(e)
                self.asian.remove(e)
                
                
    def deletion(self, foodType, foodName):
        if foodType=="한식":
            self.korean.remove(foodName)
        if foodType=="일식":
            self.japanese.remove(foodName)
        if foodType=="중식":
            self.chinese.remove(foodName)
        if foodType=="양식":
            self.western.remove(foodName)
        if foodType=="아시안":    
           self.asian.remove(foodName)
           
           
    def search(self, x):
        self.searchValue = x
        self.found_name = None
        self.found_value = None # 초기값 설정
        for name, lst in [("한식", self.korean), ("양식", self.western), ("아시안", self.asian), ("중식", self.chinese), ("일식", self.japanese)]:
            if self.searchValue in lst:
                self.found_value = lst
                self.found_name = name
                break

        return self.found_value, self.found_name

    def resultPrint(self):
        print("메뉴 추천 결과입니다.")
        print(("[ 구분 | " + " | ".join(self.dayList) + " ]"))
        print(("[ 카테고리 | " + " | ".join(self.categoryList) + " ]"))
        for i in range (len(self.coachList)):
            print("[ " + self.coachList[i] +" | "+ " | ".join(self.listSeparation(self.coachEating)[i]) + " ]")  
        print("추천을 완료했습니다.")
            
    
    def listSeparation(self,listX):
        self.length=len(listX)
        self.output = [listX[i:i+5] for i in range(0, self.length, 5)]
        return self.output     

    def mainAction(self):
        self.coachEating=[]
        for name in self.coachList:
            self.oneCannot=[]
            self.oneCannot.append(self.cannotEat[name])
            if self.oneCannot[0]==None:
                self.recommend()
            elif len(self.oneCannot[0]) == 1:
                self.found_value, self.found_name = self.search(self.oneCannot[0])
                self.deletion(self.found_value, self.found_name)
                self.recommend()
            elif len(self.oneCannot[0]) == 2:
                self.found_value1, self.found_name1 = self.search(self.oneCannot[0][0])
                self.found_value2, self.found_name2 = self.search(self.oneCannot[0][1])
                self.deletion(self.found_value1, self.found_name1)
                self.deletion(self.found_value2, self.found_name2)
                self.recommend()
            self.__init__()


if __name__=="__main__":
    print("점심 메뉴 추천을 시작합니다.")
    a=MenuRecommendation()
    a.askName()
    a.notEdible()   
    a.randomChoice()
    a.mainAction() 
    a.resultPrint()

    