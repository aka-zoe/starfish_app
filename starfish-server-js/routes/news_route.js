// routes/news_route.js
const express = require('express');
const router = express.Router();
const pool = require('../db/db');

// 获取所有新闻
router.get('/', async (req, res) => {
    try {
        const [rows] = await pool.query('SELECT * FROM news');
        res.json(rows);
    } catch (error) {
        console.error(error);
        res.status(500).send('获取新闻数据时出错');
    }
});

// 创建新新闻
router.post('/', async (req, res) => {
    const { title, content } = req.body;
    try {
        const result = await pool.query('INSERT INTO news (title, content) VALUES (?, ?)', [title, content]);
        res.json({ message: '新闻创建成功', id: result[0].insertId });
    } catch (error) {
        console.error(error);
        res.status(500).send('创建新闻时出错');
    }
});

// 更新新闻
router.put('/:id', async (req, res) => {
    const { id } = req.params;
    const { title, content } = req.body;
    try {
        await pool.query('UPDATE news SET title = ?, content = ? WHERE id = ?', [title, content, id]);
        res.json({ message: '新闻更新成功' });
    } catch (error) {
        console.error(error);
        res.status(500).send('更新新闻时出错');
    }
});

// 删除新闻
router.delete('/:id', async (req, res) => {
    const { id } = req.params;
    try {
        await pool.query('DELETE FROM news WHERE id = ?', [id]);
        res.json({ message: '新闻删除成功' });
    } catch (error) {
        console.error(error);
        res.status(500).send('删除新闻时出错');
    }
});

module.exports = router;
