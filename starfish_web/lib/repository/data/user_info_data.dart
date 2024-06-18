/// id : 1
/// name : "Zoe"
/// password : "123456"
/// role : "admin"
/// createTime : "2023-10-21 22:24:00"
/// workNumber : "23789"
/// email : "sensen.gong@alpha-ess.com"
/// address : "苏州"
/// phone : "15061442013"
/// gender : "男"
/// age : 25
/// status : 0
/// token : "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsImV4cCI6MTcxODU0MzkyOSwidXNlcm5hbWUiOiJab2UifQ.nYCKecQ2a_vo8-m5PG0xNwsjqHfcRGdgBAc1mCIM0_4"

class UserInfoData {
  UserInfoData({
    this.id,
    this.name,
    this.password,
    this.role,
    this.createTime,
    this.workNumber,
    this.email,
    this.address,
    this.phone,
    this.gender,
    this.age,
    this.status,
    this.token,
  });

  UserInfoData.fromJson(dynamic json) {
    id = json['id'];
    name = json['name'];
    password = json['password'];
    role = json['role'];
    createTime = json['createTime'];
    workNumber = json['workNumber'];
    email = json['email'];
    address = json['address'];
    phone = json['phone'];
    gender = json['gender'];
    age = json['age'];
    status = json['status'];
    token = json['token'];
  }

  num? id;
  String? name;
  String? password;
  String? role;
  String? createTime;
  String? workNumber;
  String? email;
  String? address;
  String? phone;
  String? gender;
  num? age;
  num? status;
  String? token;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['name'] = name;
    map['password'] = password;
    map['role'] = role;
    map['createTime'] = createTime;
    map['workNumber'] = workNumber;
    map['email'] = email;
    map['address'] = address;
    map['phone'] = phone;
    map['gender'] = gender;
    map['age'] = age;
    map['status'] = status;
    map['token'] = token;
    return map;
  }
}
