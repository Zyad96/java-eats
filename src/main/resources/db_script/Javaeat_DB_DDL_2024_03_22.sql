/*  Javaeat_lites definition  */



/* Create the database schema */
--CREATE DATABASE javaeat_lites;

/* Use the database */
--USE javaeat_lites;

/* Create the schema */
--CREATE SCHEMA javaeat_lites;


/* Create the tables */

CREATE TABLE IF NOT EXISTS "javaeat_lites"."user" (
                                                      "user_id" SERIAL PRIMARY KEY,
                                                      name VARCHAR(255) NOT NULL,
                                                      email VARCHAR(255) NOT NULL UNIQUE,
                                                      password VARCHAR(255) NOT NULL,
                                                      user_type_id INTEGER NOT NULL,
                                                      phone VARCHAR(255) NOT NULL,
                                                      status VARCHAR(255) NOT NULL DEFAULT 'active',
                                                      created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                      updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".role (
                                                    role_id SERIAL PRIMARY KEY,
                                                    name VARCHAR(255) NOT NULL,
                                                    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".user_role (
                                                         user_role_id SERIAL PRIMARY KEY,
                                                         "user_id" INTEGER NOT NULL,
                                                         role_id INTEGER NOT NULL,
                                                         created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                         updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                         UNIQUE (user_id, role_id)
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".user_type (
                                                         user_type_id SERIAL PRIMARY KEY,
                                                         name VARCHAR(255) NOT NULL,
                                                         created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                         updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".customer (
                                                        customer_id SERIAL PRIMARY KEY,
                                                        "user_id" INTEGER NOT NULL,
                                                        created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                        updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".address (
                                                       address_id SERIAL PRIMARY KEY,
                                                       customer_id INTEGER NOT NULL,
                                                       address_line1 VARCHAR(255) NOT NULL,
                                                       address_line2 VARCHAR(255),
                                                       city VARCHAR(255) NOT NULL,
                                                       street VARCHAR(255),
                                                       country VARCHAR(255) NOT NULL DEFAULT 'EGYPT',
                                                       created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                       updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".restaurant (
                                                          restaurant_id SERIAL PRIMARY KEY,
                                                          name VARCHAR(255) NOT NULL,
                                                          status VARCHAR(255) NOT NULL DEFAULT 'open',
                                                          created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                          updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                          UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".restaurant_details (
                                                                  restaurant_details_id SERIAL PRIMARY KEY,
                                                                  restaurant_id INTEGER NOT NULL,
                                                                  description TEXT NOT NULL,
                                                                  created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                  updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".menu (
                                                    menu_id SERIAL PRIMARY KEY,
                                                    restaurant_id INTEGER NOT NULL,
                                                    name VARCHAR(255) NOT NULL,
                                                    status VARCHAR(255) NOT NULL DEFAULT 'active',
                                                    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                    UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".menu_item (
                                                         menu_item_id SERIAL PRIMARY KEY,
                                                         menu_id INTEGER NOT NULL,
                                                         name VARCHAR(255) NOT NULL,
                                                         description TEXT,
                                                         price NUMERIC NOT NULL,
                                                         status VARCHAR(255) NOT NULL DEFAULT 'available',
                                                         created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                         updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                         UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".ingredient (
                                                          ingredient_id SERIAL PRIMARY KEY,
                                                          name VARCHAR(255) NOT NULL,
                                                          description TEXT,
                                                          allergens TEXT,
                                                          unit VARCHAR(255),
                                                          cost NUMERIC,
                                                          stock_quantity INTEGER NOT NULL,
                                                          storage_instructions TEXT,
                                                          created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                          updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                          UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".menu_item_ingredient (
                                                                    menu_item_ingredient_id SERIAL PRIMARY KEY,
                                                                    menu_item_id INTEGER NOT NULL,
                                                                    ingredient_id INTEGER NOT NULL,
                                                                    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                    UNIQUE (menu_item_id, ingredient_id)
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".cart (
                                                    cart_id SERIAL PRIMARY KEY,
                                                    customer_id INTEGER NOT NULL,
                                                    subtotal NUMERIC NOT NULL,
                                                    tax NUMERIC NOT NULL,
                                                    total NUMERIC NOT NULL,
                                                    status VARCHAR(255) NOT NULL DEFAULT 'active',
                                                    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                    updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                    UNIQUE (customer_id, status)
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".cart_item (
                                                         cart_item_id SERIAL PRIMARY KEY,
                                                         cart_id INTEGER NOT NULL,
                                                         menu_item_id INTEGER NOT NULL,
                                                         quantity INTEGER NOT NULL,
                                                         unit_price NUMERIC NOT NULL,
                                                         total_price NUMERIC NOT NULL,
                                                         created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                         updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites"."order" (
                                                       order_id SERIAL PRIMARY KEY,
                                                       customer_id INTEGER NOT NULL,
                                                       order_date TIMESTAMP NOT NULL,
                                                       subtotal NUMERIC NOT NULL,
                                                       tax NUMERIC NOT NULL,
                                                       total NUMERIC NOT NULL,
                                                       order_status_id INTEGER NOT NULL,
                                                       created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                       updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".order_item (
                                                          order_item_id SERIAL PRIMARY KEY,
                                                          order_id INTEGER NOT NULL,
                                                          menu_item_id INTEGER NOT NULL,
                                                          quantity INTEGER NOT NULL,
                                                          price NUMERIC NOT NULL,
                                                          status VARCHAR(255) NOT NULL DEFAULT 'pending',
                                                          created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                          updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP  ,
                                                          UNIQUE (order_id, menu_item_id)
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".order_status (
                                                            order_status_id SERIAL PRIMARY KEY,
                                                            status VARCHAR(255) NOT NULL,
                                                            created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                            updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".order_tracking (
                                                              order_tracking_id SERIAL PRIMARY KEY,
                                                              order_id INTEGER NOT NULL,
                                                              current_location VARCHAR(255) NOT NULL,
                                                              estimated_delivery_time TIMESTAMP NOT NULL,
                                                              created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                              updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".payment_integration_type (
                                                                        payment_integration_type_id SERIAL PRIMARY KEY,
                                                                        name VARCHAR(255) NOT NULL,
                                                                        description TEXT,
                                                                        created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                        updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".payment_type_configuration (
                                                                          payment_type_configuration_id SERIAL PRIMARY KEY,
                                                                          payment_integration_type_id INTEGER NOT NULL,
                                                                          configuration_details TEXT NOT NULL,
                                                                          created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                          updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".preferred_payment_setting (
                                                                         preferred_payment_setting_id SERIAL PRIMARY KEY,
                                                                         customer_id INTEGER NOT NULL,
                                                                         payment_type_config_id INTEGER NOT NULL,
                                                                         created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                         updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites"."transaction" (
                                                             transaction_id SERIAL PRIMARY KEY,
                                                             order_id INTEGER NOT NULL,
                                                             amount NUMERIC NOT NULL,
                                                             transaction_status_id INTEGER NOT NULL,
                                                             created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                             updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".transaction_details (
                                                                   transaction_details_id SERIAL PRIMARY KEY,
                                                                   transaction_id INTEGER NOT NULL,
                                                                   details TEXT NOT NULL,
                                                                   created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                   updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".transaction_status (
                                                                  transaction_status_id SERIAL PRIMARY KEY,
                                                                  name VARCHAR(255) NOT NULL,
                                                                  created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                  updated_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "javaeat_lites".auditing (
                                                        auditing_id SERIAL NOT NULL PRIMARY KEY,
                                                        "user_id" INTEGER NOT NULL,
                                                        "action" VARCHAR(255) NOT NULL,
                                                        details JSONB NOT NULL,
                                                        "timestamp" TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE "javaeat_lites"."user" ADD FOREIGN KEY (user_type_id) REFERENCES "javaeat_lites".user_type(user_type_id);
ALTER TABLE "javaeat_lites".user_role ADD FOREIGN KEY ("user_id") REFERENCES "user"("user_id");
ALTER TABLE "javaeat_lites".user_role ADD FOREIGN KEY (role_id) REFERENCES role(role_id);
ALTER TABLE "javaeat_lites".customer ADD FOREIGN KEY (user_id) REFERENCES "user"("user_id");
ALTER TABLE "javaeat_lites".address ADD FOREIGN KEY (customer_id) REFERENCES "javaeat_lites".customer(customer_id);
ALTER TABLE "javaeat_lites".restaurant_details ADD FOREIGN KEY (restaurant_id) REFERENCES "javaeat_lites".restaurant(restaurant_id);
ALTER TABLE "javaeat_lites".menu ADD FOREIGN KEY (restaurant_id) REFERENCES "javaeat_lites".restaurant(restaurant_id);
ALTER TABLE "javaeat_lites".menu_item ADD FOREIGN KEY (menu_id) REFERENCES "javaeat_lites".menu(menu_id);
ALTER TABLE "javaeat_lites".menu_item_ingredient ADD FOREIGN KEY (menu_item_id) REFERENCES "javaeat_lites".menu_item(menu_item_id);
ALTER TABLE "javaeat_lites".menu_item_ingredient ADD FOREIGN KEY (ingredient_id) REFERENCES "javaeat_lites".ingredient(ingredient_id);
ALTER TABLE "javaeat_lites".cart ADD FOREIGN KEY (customer_id) REFERENCES "javaeat_lites".customer(customer_id);
ALTER TABLE "javaeat_lites".cart_item ADD FOREIGN KEY (cart_id) REFERENCES "javaeat_lites".cart(cart_id);
ALTER TABLE "javaeat_lites".cart_item ADD FOREIGN KEY (menu_item_id) REFERENCES "javaeat_lites".menu_item(menu_item_id);
ALTER TABLE "javaeat_lites"."order" ADD FOREIGN KEY (customer_id) REFERENCES "javaeat_lites".customer(customer_id);
ALTER TABLE "javaeat_lites"."order" ADD FOREIGN KEY (order_status_id) REFERENCES "javaeat_lites".order_status(order_status_id);
ALTER TABLE "javaeat_lites".order_item ADD FOREIGN KEY (order_id) REFERENCES "javaeat_lites"."order"("order_id");
ALTER TABLE "javaeat_lites".order_item ADD FOREIGN KEY (menu_item_id) REFERENCES "javaeat_lites".menu_item(menu_item_id);
ALTER TABLE "javaeat_lites".order_tracking ADD FOREIGN KEY (order_id) REFERENCES "javaeat_lites"."order"("order_id");
ALTER TABLE "javaeat_lites".payment_type_configuration ADD FOREIGN KEY (payment_integration_type_id) REFERENCES "javaeat_lites".payment_integration_type(payment_integration_type_id);
ALTER TABLE "javaeat_lites".preferred_payment_setting ADD FOREIGN KEY (customer_id) REFERENCES "javaeat_lites".customer(customer_id);
ALTER TABLE "javaeat_lites".preferred_payment_setting ADD FOREIGN KEY (payment_type_config_id) REFERENCES "javaeat_lites".payment_type_configuration(payment_type_configuration_id);
ALTER TABLE "javaeat_lites"."transaction" ADD FOREIGN KEY (order_id) REFERENCES "javaeat_lites"."order"("order_id");
ALTER TABLE "javaeat_lites"."transaction" ADD FOREIGN KEY (transaction_status_id) REFERENCES "javaeat_lites".transaction_status(transaction_status_id);
ALTER TABLE "javaeat_lites".transaction_details ADD FOREIGN KEY (transaction_id) REFERENCES "javaeat_lites"."transaction"(transaction_id);
ALTER TABLE "javaeat_lites".auditing ADD FOREIGN KEY ("user_id") REFERENCES "javaeat_lites"."user"("user_id");
