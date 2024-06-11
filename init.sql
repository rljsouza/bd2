DO
$$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'core') THEN
        CREATE DATABASE core;
    END IF;
END
$$;
