const userModel = require('../models/user_model');
const {where} = require("sequelize");

class UserController {
    static async getAllUsers() {
        return await userModel.findAll();
    }

    static async getUserById(id) {
        return await userModel.findAll({where: {id: id}});
    }

    static async getUserByInfo(name, pwd) {
        return await userModel.findAll({where: {name: name, password: pwd}});
    }

    static async addUser(req) {
        const i = await userModel.create({name: req.name, password: req.password, pid: req.pid.toString()});
        return i[0] === 1
    }

    static async update(req) {
        const i = await userModel.update({req}, {where: {id: req.id}});
        return i[0] === 1
    }

    static async setUmToken(id, umToken) {
        const i = await userModel.update({um_token: umToken}, {where: {id: id}})
        return i[0] === 1
    }

    /**
     *
     * @param id
     * @param openFlag 0 关闭，1 开启
     * @returns {Promise<boolean>}
     */
    static async setMsgOpen(id, openFlag) {
        const i = await userModel.update({open_msg: openFlag ? 1 : 0}, {where: {id: id}})
        return i[0] === 1
    }
}

module.exports = {
    UserController
}
