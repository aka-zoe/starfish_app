// routes/banner_route.js
const express = require('express');
const router = express.Router();
const pool = require('../db/db');

// 获取所有 banner
router.get('/', async (req, res) => {
    try {
        const [rows] = await pool.query('SELECT * FROM banners');
        res.json(rows);
    } catch (error) {
        console.error(error);
        res.status(500).send('获取 banner 数据时出错');
    }
});

// 创建新 banner
router.post('/', async (req, res) => {
    const { title, image_url } = req.body;
    try {
        const result = await pool.query('INSERT INTO banners (title, image_url) VALUES (?, ?)', [title, image_url]);
        res.json({ message: 'banner 创建成功', id: result[0].insertId });
    } catch (error) {
        console.error(error);
        res.status(500).send('创建 banner 时出错');
    }
});

// 更新 banner
router.put('/:id', async (req, res) => {
    const { id } = req.params;
    const { title, image_url } = req.body;
    try {
        await pool.query('UPDATE banners SET title = ?, image_url = ? WHERE id = ?', [title, image_url, id]);
        res.json({ message: 'banner 更新成功' });
    } catch (error) {
        console.error(error);
        res.status(500).send('更新 banner 时出错');
    }
});

// 删除 banner
router.delete('/:id', async (req, res) => {
    const { id } = req.params;
    try {
        await pool.query('DELETE FROM banners WHERE id = ?', [id]);
        res.json({ message: 'banner 删除成功' });
    } catch (error) {
        console.error(error);
        res.status(500).send('删除 banner 时出错');
    }
});

module.exports = router;
