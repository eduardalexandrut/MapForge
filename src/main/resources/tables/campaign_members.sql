CREATE TABLE IF NOT EXISTS campaign_members (
    owner INT NOT NULL REFERENCES users(id),
    campaign INT NOT NULL REFERENCES campaigns(id),
    hp INT NOT NULL,
    xp INT NOT NULL,
    PRIMARY KEY (owner, campaign)
);