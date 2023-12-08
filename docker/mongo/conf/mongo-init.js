var config = {
  _id: "rs0",
  members: [
    { _id: 0, host: "mongo:27017", priority: 1  },
    { _id: 1, host: "mongo-1:27018", priority: 2 },
    { _id: 2, host: "mongo-2:27019", priority: 3 },
  ]
};
rs.initiate(config, {force: true});
rs.status();