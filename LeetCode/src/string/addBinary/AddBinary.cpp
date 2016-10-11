#include <string>
#include <iostream>
using namespace std;


string addBinary(string a, string b) {
	int na = a.size(), nb = b.size(), carry = 0;
	int n = na > nb ? na : nb;
	string res(n + 1, ' ');
	--na;
	--nb;
	while (na>=0&&nb>=0)
	{
		if (a[na] == '1'&&b[nb]=='1') {
			res[n--] = carry + '0';
			carry = 1;
		}
		else if (a[na] == '0' && b[nb] == '0') {
			res[n--] = carry + '0';
			carry = 0;
		}
		else {
			if (carry)
				res[n--] = '0';
			else {
				res[n--] = '1';
			}
		}
		--na; --nb;
	}
	while (na >= 0) {
		if (carry && a[na] == '1') {
			res[n--] = '0';
			carry = 1;
		}
		else if (carry && a[na] == '0') {
			res[n--] = carry + '0';
			carry = 0;
		}
		else {
			res[n--] = a[na];
		}
		--na;
	}	
	while (nb >= 0) {
		if (carry && a[nb] == '1') {
			res[n--] = '0';
			carry = 1;
		}
		else if (carry && a[nb] == '0') {
			res[n--] = carry + '0';
			carry = 0;
		}
		else {
			res[n--] = a[nb];
		}
		--nb;
	}
	if (carry) {
		res[0] = '1';
		return res;
	}
	else {
		return res.substr(1);
	}
}

int main() {
	string a = "0", b = "1";
	string res = addBinary(a, b);
	cout << res << endl;
}