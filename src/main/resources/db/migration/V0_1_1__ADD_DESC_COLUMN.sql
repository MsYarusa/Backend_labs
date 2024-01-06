ALTER TABLE todos ADD IF NOT EXISTS description VARCHAR(255);

-- также укажем описание для уже добавленных задач
UPDATE todos SET description='default description';