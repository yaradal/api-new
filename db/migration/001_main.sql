
CREATE TYPE data_type AS ENUM ('type1', 'type2');

CREATE TABLE post (
      id          SERIAL PRIMARY KEY,
      comment_id INTEGER,
      title         TEXT NOT NULL CHECK (key != ''),
      content        TEXT NOT NULL,
      created_at   DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE INDEX supplier_product_by_supplier_id ON supplier_product (supplier_id);
//   var id: Long ,
    var title: String ,
    var content: String,
    @Column(name="created_at")
    var createdAt: Date