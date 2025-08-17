// src/components/ServiceCard.jsx
import React from "react";

function ServiceCard({ service }) {
  return (
    <div className="col-md-6 col-lg-4 mb-4">
      <div className="card h-100">
        <div className="card-body">
          <h5 className="card-title">{service.serviceName}</h5>
          <p className="card-text">Price: <span className="text-primary">${service.price}</span></p>
          <p className="mb-1 fw-bold">Fabrics Available:</p>
          <ul className="mb-0">



            
            {service.fabricsAvailable.map((fabric, idx) => (
              <li key={idx}>{fabric}</li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
}

export default ServiceCard;
