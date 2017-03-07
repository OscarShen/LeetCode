class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> res;
        for(int i=1;i<=n;++i){
            if(i%15==0){
                res.push_back(string("FizzBuzz"));
            } else if(i%3==0){
                res.push_back(string("Fizz"));
            } else if(i%5==0){
                res.push_back(string("Buzz"));
            }else{
                string str;
                int j=i;
                while(j>0){
                    int k = j%10;
                    str+=('0'+k);
                    j/=10;
                }
                int size = str.size();
                int halfSize = size/2;
                for(int l = 0;l<halfSize;++l){
                    char c = str[l];
                    str[l]=str[size-1-l];
                    str[size-1-l]=c;
                }
                res.push_back(str);
            }
        }
        return res;
    }
};