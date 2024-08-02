/// id : 1
/// imageList : ["https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png","https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png","https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png","https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png","https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png","https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png","https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png","https://q9.itc.cn/images01/20240312/6012df31dff3413bb7815b136e98207e.png"]
/// houseDesc : "近地铁 押一付三"
/// leaseType : 0
/// rent : 3000
/// serviceCharge : 150
/// houseTypeName : "一室一厅一卫"
/// houseType : 2
/// direction : "朝南"
/// checkInDate : "2024-06-14 12:12:12"
/// totalFloor : 32
/// currentFloor : 10
/// houseArea : "翻斗花园二期"
/// acreage : 110
/// publishDate : "2024-04-13 00:00:00"
/// fitment : "精装修"
/// paymentType : 0
/// bed : true
/// washingMachine : true
/// refrigerator : true
/// airConditioner : true
/// wifi : true
/// sofa : true
/// tableChair : true
/// tv : false
/// waterHeater : false
/// cook : false
/// heating : false
/// balcony : false
/// longitude : "经度"
/// latitude : "纬度"
/// publisher : "小明"
/// publisherNumber : "12344441111"
/// tagList : [{"id":1,"houseResId":1,"name":"近地铁","type":"0","createTime":"2024-05-12T16:00:00.000+00:00","status":0},{"id":2,"houseResId":1,"name":"在线签约","type":"0","createTime":"2024-05-12T16:00:00.000+00:00","status":0},{"id":3,"houseResId":1,"name":"整租","type":"1","createTime":"2024-05-12T16:00:00.000+00:00","status":0},{"id":4,"houseResId":1,"name":"不要钱22","type":"0","createTime":"2024-05-12T16:00:00.000+00:00","status":0},{"id":6,"houseResId":1,"name":"不要钱2","type":"0","createTime":null,"status":0}]
/// publisherId : 1
/// publisherType : "中介"
/// publisherHead : ""

///房源明细返回数据
class HouseResDetailData {
  HouseResDetailData({
    this.id,
    this.imageList,
    this.houseDesc,
    this.leaseType,
    this.rent,
    this.serviceCharge,
    this.houseTypeName,
    this.houseType,
    this.direction,
    this.checkInDate,
    this.totalFloor,
    this.currentFloor,
    this.houseArea,
    this.acreage,
    this.publishDate,
    this.fitment,
    this.paymentType,
    this.bed,
    this.washingMachine,
    this.refrigerator,
    this.airConditioner,
    this.wifi,
    this.sofa,
    this.tableChair,
    this.tv,
    this.waterHeater,
    this.cook,
    this.heating,
    this.balcony,
    this.longitude,
    this.latitude,
    this.publisher,
    this.publisherNumber,
    this.tagList,
    this.publisherId,
    this.publisherType,
    this.publisherHead,
  });

  HouseResDetailData.fromJson(dynamic json) {
    id = json['id'];
    if (json['imageList'] != null && json['imageList'] is List) {
      imageList = json['imageList'].cast<String>();
    } else {
      imageList = [];
    }

    houseDesc = json['houseDesc'];
    leaseType = json['leaseType'];
    rent = json['rent'];
    serviceCharge = json['serviceCharge'];
    houseTypeName = json['houseTypeName'];
    houseType = json['houseType'];
    direction = json['direction'];
    checkInDate = json['checkInDate'];
    totalFloor = json['totalFloor'];
    currentFloor = json['currentFloor'];
    houseArea = json['houseArea'];
    acreage = json['acreage'];
    publishDate = json['publishDate'];
    fitment = json['fitment'];
    paymentType = json['paymentType'];
    bed = json['bed'];
    washingMachine = json['washingMachine'];
    refrigerator = json['refrigerator'];
    airConditioner = json['airConditioner'];
    wifi = json['wifi'];
    sofa = json['sofa'];
    tableChair = json['tableChair'];
    tv = json['tv'];
    waterHeater = json['waterHeater'];
    cook = json['cook'];
    heating = json['heating'];
    balcony = json['balcony'];
    carport = json['carport'];
    longitude = json['longitude'];
    latitude = json['latitude'];
    publisher = json['publisher'];
    publisherNumber = json['publisherNumber'];
    if (json['tagList'] != null && json['tagList'] is List) {
      tagList = [];
      json['tagList'].forEach((v) {
        tagList?.add(TagList.fromJson(v));
      });
    } else {
      tagList = [];
    }
    publisherId = json['publisherId'];
    publisherType = json['publisherType'];
    publisherHead = json['publisherHead'];
  }

  num? id;
  List<String?>? imageList;
  String? houseDesc;
  num? leaseType;
  num? rent;
  num? serviceCharge;
  String? houseTypeName;
  num? houseType;
  String? direction;
  String? checkInDate;
  num? totalFloor;
  num? currentFloor;
  String? houseArea;
  num? acreage;
  String? publishDate;
  String? fitment;
  num? paymentType;
  bool? bed;
  bool? washingMachine;
  bool? refrigerator;
  bool? airConditioner;
  bool? wifi;
  bool? sofa;
  bool? tableChair;
  bool? tv;
  bool? waterHeater;
  bool? cook;
  bool? heating;
  bool? balcony;
  bool? carport;
  String? longitude;
  String? latitude;
  String? publisher;
  String? publisherNumber;
  List<TagList>? tagList;
  num? publisherId;
  String? publisherType;
  String? publisherHead;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['imageList'] = imageList;
    map['houseDesc'] = houseDesc;
    map['leaseType'] = leaseType;
    map['rent'] = rent;
    map['serviceCharge'] = serviceCharge;
    map['houseTypeName'] = houseTypeName;
    map['houseType'] = houseType;
    map['direction'] = direction;
    map['checkInDate'] = checkInDate;
    map['totalFloor'] = totalFloor;
    map['currentFloor'] = currentFloor;
    map['houseArea'] = houseArea;
    map['acreage'] = acreage;
    map['publishDate'] = publishDate;
    map['fitment'] = fitment;
    map['paymentType'] = paymentType;
    map['bed'] = bed;
    map['washingMachine'] = washingMachine;
    map['refrigerator'] = refrigerator;
    map['airConditioner'] = airConditioner;
    map['wifi'] = wifi;
    map['sofa'] = sofa;
    map['tableChair'] = tableChair;
    map['tv'] = tv;
    map['waterHeater'] = waterHeater;
    map['cook'] = cook;
    map['heating'] = heating;
    map['balcony'] = balcony;
    map['carport'] = carport;
    map['longitude'] = longitude;
    map['latitude'] = latitude;
    map['publisher'] = publisher;
    map['publisherNumber'] = publisherNumber;
    if (tagList != null) {
      map['tagList'] = tagList?.map((v) => v.toJson()).toList();
    }
    map['publisherId'] = publisherId;
    map['publisherType'] = publisherType;
    map['publisherHead'] = publisherHead;
    return map;
  }
}

/// id : 1
/// houseResId : 1
/// name : "近地铁"
/// type : "0"
/// createTime : "2024-05-12T16:00:00.000+00:00"
/// status : 0

class TagList {
  TagList({
    this.id,
    this.houseResId,
    this.name,
    this.type,
    this.createTime,
    this.status,
  });

  TagList.fromJson(dynamic json) {
    id = json['id'];
    houseResId = json['houseResId'];
    name = json['name'];
    type = json['type'];
    createTime = json['createTime'];
    status = json['status'];
  }

  num? id;
  num? houseResId;
  String? name;
  String? type;
  String? createTime;
  num? status;

  Map<String, dynamic> toJson() {
    final map = <String, dynamic>{};
    map['id'] = id;
    map['houseResId'] = houseResId;
    map['name'] = name;
    map['type'] = type;
    map['createTime'] = createTime;
    map['status'] = status;
    return map;
  }
}
