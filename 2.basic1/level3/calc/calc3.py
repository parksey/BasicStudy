class calculator:
    def __init__(self):
        self.calculationList=[]
        self.valid_chars = ['+', '-', '*', '/']
    def calculation(self):
    
        while True:
            print("계산할 수식을 입력해 주세요.")
            try:
                equation=input()
                equation= equation.replace(" ","")
                if equation[-1]=="=":
                    for char in equation:
                        if char in self.valid_chars and not char.isdigit():
                            result=eval(equation[:-1])
                            self.calculationList.append(equation+str(result))
                            return result
                    
                else:
                    raise ValueError
                
            except ValueError:
                print("[ERROR1]")
                continue
            except:
                print("[ERROR2]")
            break

    def browse(self):
        for equation in self.calculationList:
            print(equation)
            


    def runCalculator(self):
        print("계산기를 시작합니다.")
        while True:
            print("계산 시작하기(1), 사용한 계산식 가져오기(2)")
            try:
                userInput=input()
                if userInput=="1":
                    print("최종 결과 값:", self.calculation())
                elif userInput=="2":
                    self.browse()
                elif userInput=="QUIT":
                    print("계산기를 종료합니다.")
                    break
                else:
                    raise ValueError

            except ValueError:
                print("[ERROR3]")
            except:
                print("[ERROR4]")
                
if __name__=="__main__":
        
    a = calculator()
    a.runCalculator()      