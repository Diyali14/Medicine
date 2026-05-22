from fastapi import FastAPI
from pydantic import BaseModel
import pandas as pd
import joblib

app = FastAPI()

model = joblib.load("hospital_inventory_model.pkl")

class HospitalData(BaseModel):

    hospital_id: int
    hospital_type: int
    medicine_name: int
    current_stock: int
    threshold_limit: int
    avg_daily_usage: int
    weekly_usage: int
    monthly_usage: int
    season: int
    emergency_cases: int
    expiry_risk: float
    vendor_delay_days: int

@app.get("/")
def home():

    return {
        "message": "Hospital AI Service Running"
    }

@app.post("/predict")
def predict(data: HospitalData):

    input_data = pd.DataFrame([{
        "hospital_id": data.hospital_id,
        "hospital_type": data.hospital_type,
        "medicine_name": data.medicine_name,
        "current_stock": data.current_stock,
        "threshold_limit": data.threshold_limit,
        "avg_daily_usage": data.avg_daily_usage,
        "weekly_usage": data.weekly_usage,
        "monthly_usage": data.monthly_usage,
        "season": data.season,
        "emergency_cases": data.emergency_cases,
        "expiry_risk": data.expiry_risk,
        "vendor_delay_days": data.vendor_delay_days
    }])

    prediction = model.predict(input_data)

    prediction_value = float(prediction[0])

    if prediction_value > 500:

        message = (
            "Medicine stock may run low soon"
        )

    else:

        message = (
            "Stock level manageable"
        )

    return {

        "predicted_reorder_quantity":
        prediction_value,

        "prediction_message":
        message
    }