



                            //芝士汉堡函数1.0
                            function burgerMakeV1() {
                                console.log("把面包加热至金黄色")
                                console.log("将牛肉饼煎至完美熟度")
                                console.log("给肉饼刷上汉堡酱")
                                console.log("加入奶酪片")
                                console.log("清洗番茄并切片")
                                console.log("清洗生菜并切碎")
                                console.log("把食材叠在一起，成功！")
                            }










                            //汉堡制作函数2.0
                            function burgerMakerV2(type) {
                                let meat;
                                if (type === 1) {
                                    meat = "牛肉"
                                } else if (type === 2) {
                                    meat = "鸡肉"
                                } else {
                                    meat = "鱼肉"
                                }
                                console.log("把面包加热至金黄色")
                                console.log("将" + meat + "饼煎至完美熟度")
                                console.log("给肉饼刷上汉堡酱")
                                console.log("加入奶酪片")
                                console.log("清洗番茄并切片")
                                console.log("清洗生菜并切碎")
                                console.log("把食材叠在一起，成功！")
                            }


                            /**
                             * 开始制作汉堡er
                             */
                            function startMakerBurger() {

                                //制作牛肉汉堡
                                burgerMakeV3(beef)
                                //制作鸡肉汉堡
                                burgerMakeV3(chicken)
                                //制作鱼肉汉堡
                                burgerMakeV3(fish)
                            }

                            //汉堡制作函数3.0
                            function burgerMakeV3(func) {
                                console.log("把面包加热至金黄色")
                                func.call()
                                console.log("给肉饼刷上汉堡酱")
                                console.log("加入奶酪片")
                                console.log("清洗番茄并切片")
                                console.log("清洗生菜并切碎")
                                console.log("把食材叠在一起，成功！")
                            }









                            function beef() {
                                console.log("将牛肉饼煎至完美熟度")
                            }

                            function chicken() {
                                console.log("将鸡肉饼煎至完美熟度")
                            }

                            function fish() {
                                console.log("将鱼肉饼煎至完美熟度")
                            }













                            function main(){

                            }

