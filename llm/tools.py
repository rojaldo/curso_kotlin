import asyncio
from ollama import ChatResponse
import ollama


def add_two_numbers(a: int, b: int) -> int:
  """
  Add two numbers

  Args:
    a (int): The first number
    b (int): The second number

  Returns:
    int: The sum of the two numbers
  """
  
#   cast to int 
  a = int(a)
  b = int(b)

  return a + b


def subtract_two_numbers(a: int, b: int) -> int:
  """
  Subtract two numbers
  """
#   cast to int
  a = int(a)
  b = int(b)
  return a - b

def get_rectangle_area(length: int, width: int) -> float:
  """
  Get the area of a rectangle
  """
#   cast to int
  length = int(length)
  width = int(width)
  return length * width

def get_circle_area(radius: int) -> float:
  """
  Get the area of a circle
  """
#   cast to int
  radius = int(radius)
  return 3.14159 * radius ** 2


# Tools can still be manually defined and passed into chat
subtract_two_numbers_tool = {
  'type': 'function',
  'function': {
    'name': 'subtract_two_numbers',
    'description': 'Subtract two numbers',
    'parameters': {
      'type': 'object',
      'required': ['a', 'b'],
      'properties': {
        'a': {'type': 'integer', 'description': 'The first number'},
        'b': {'type': 'integer', 'description': 'The second number'},
      },
    },
  },
}


async def main():
#   client = ollama.AsyncClient()

  client = ollama.AsyncClient( host='http://10.10.0.111:11434',headers={'x-some-header': 'some-value'})

  prompt = 'calcula la extensión de una plaza circular de 25 metros'
  print('Prompt:', prompt)

  available_functions = {
    'add_two_numbers': add_two_numbers,
    'subtract_two_numbers': subtract_two_numbers,
    'get_rectangle_area': get_rectangle_area,
    'get_circle_area': get_circle_area
  }

  response: ChatResponse = await client.chat(
    'llama3.2',
    messages=[{'role': 'user', 'content': prompt}],
    tools=[add_two_numbers, subtract_two_numbers_tool, get_rectangle_area, get_circle_area]
  )

  if response.message.tool_calls:
    # There may be multiple tool calls in the response
    for tool in response.message.tool_calls:
      # Ensure the function is available, and then call it
      if function_to_call := available_functions.get(tool.function.name):
        print('Calling function:', tool.function.name)
        print('Arguments:', tool.function.arguments)
        print('Function output:', function_to_call(**tool.function.arguments))
      else:
        print('Function', tool.function.name, 'not found')


if __name__ == '__main__':
  try:
    asyncio.run(main())
  except KeyboardInterrupt:
    print('\nGoodbye!')
