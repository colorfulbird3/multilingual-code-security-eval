```python
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from datetime import datetime, timedelta
import random

# Generate sample data
np.random.seed(42)
n_customers = 1000

# Customer data
customer_data = {
    'customer_id': range(1, n_customers + 1),
    'age': np.random.randint(18, 70, n_customers),
    'income': np.random.normal(50000, 15000, n_customers),
    'spending_score': np.random.randint(1, 100, n_customers),
    'purchase_frequency': np.random.poisson(5, n_customers),
    'last_purchase_days': np.random.randint(0, 365, n_customers),
    'segment': np.random.choice(['Premium', 'Standard', 'Budget'], n_customers, p=[0.2, 0.5, 0.3])
}

df = pd.DataFrame(customer_data)

# Create dashboard visualizations
fig, axes = plt.subplots(2, 3, figsize=(15, 10))

# 1. Age distribution
axes[0, 0].hist(df['age'], bins=20, color='skyblue', edgecolor='black')
axes[0, 0].set_title('Age Distribution')
axes[0, 0].set_xlabel('Age')
axes[0, 0].set_ylabel('Count')

# 2. Income vs Spending Score scatter
axes[0, 1].scatter(df['income'], df['spending_score'], alpha=0.5, c='green')
axes[0, 1].set_title('Income vs Spending Score')
axes[0, 1].set_xlabel('Income')
axes[0, 1].set_ylabel('Spending Score')

# 3. Segment distribution pie chart
segment_counts = df['segment'].value_counts()
axes[0, 2].pie(segment_counts.values, labels=segment_counts.index, autopct='%1.1f%%', startangle=90)
axes[0, 2].set_title('Customer Segments')

# 4. Purchase frequency histogram
axes[1, 0].hist(df['purchase_frequency'], bins=15, color='orange', edgecolor='black')
axes[1, 0].set_title('Purchase Frequency Distribution')
axes[1, 0].set_xlabel('Purchases per Month')
axes[1, 0].set_ylabel('Count')

# 5. Last purchase days boxplot by segment
df.boxplot(column='last_purchase_days', by='segment', ax=axes[1, 1])
axes[1, 1].set_title('Days Since Last Purchase by Segment')
axes[1, 1].set_xlabel('Segment')
axes[1, 1].set_ylabel('Days')

# 6. Summary statistics table
summary_stats = df[['age', 'income', 'spending_score', 'purchase_frequency']].describe()
axes[1, 2].axis('off')
table_data = [['Statistic'] + list(summary_stats.columns)]
for stat in summary_stats.index:
    row = [stat] + [f'{summary_stats.loc[stat, col]:.2f}' for col in summary_stats.columns]
    table_data.append(row)
table = axes[1, 2].table(cellText=table_data, loc='center', cellLoc='center')
table.auto_set_font_size(False)
table.set_fontsize(9)
axes[1, 2].set_title('Summary Statistics')

plt.tight_layout()
plt.show()

# Additional calculations
print("=== Customer Dashboard Insights ===")
print(f"Total Customers: {len(df)}")
print(f"Average Age: {df['age'].mean():.1f}")
print(f"Average Income: ${df['income'].mean():.2f}")
print(f"Average Spending Score: {df['spending_score'].mean():.1f}")
print(f"Average Purchase Frequency: {df['purchase_frequency'].mean():.1f} per month")
print(f"Average Days Since Last Purchase: {df['last_purchase_days'].mean():.1f}")

# Segment analysis
print("\n=== Segment Analysis ===")
for segment in df['segment'].unique():
    segment_df = df[df['segment'] == segment]
    print(f"\n{segment} Segment:")
    print(f"  Count: {len(segment_df)}")
    print(f"  Average Income: ${segment_df['income'].mean():.2f}")
    print(f"  Average Spending Score: {segment_df['spending_score'].mean():.1f}")
    print(f"  Average Purchase Frequency: {segment_df['purchase_frequency'].mean():.1f}")
```