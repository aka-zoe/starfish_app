//我是某段代码
function touchFish(){
    console.log("摸鱼")
}

//将函数作为参数
function working(work){
    work.call()
}

function main(){
    //开始去上班啦
    working(touchFish)
}

main()


